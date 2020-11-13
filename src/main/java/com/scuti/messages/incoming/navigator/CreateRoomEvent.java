package com.scuti.messages.incoming.navigator;

import com.scuti.Emulator;
import com.scuti.database.Database;
import com.scuti.messages.incoming.IncomingEvent;
import com.scuti.habbohotel.rooms.Room;

import java.sql.*;

public class CreateRoomEvent extends IncomingEvent {
    @Override
    public void handle() throws SQLException {
        try(Connection connection = Database.getDB().getConnection()) {
            try(PreparedStatement statement = connection.prepareStatement("INSERT INTO rooms (owner_id, name, heightmap) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, Emulator.scuti().gameClientManager().getClients().get(this.session).getId());
                statement.setString(2, this.data.getJSONObject("data").getString("roomName"));

                int modelId = this.data.getJSONObject("data").getInt("modelId");
                if(Emulator.scuti().getRoomManager().getModelsLoaded().containsKey(modelId)) {
                    statement.setInt(3, modelId);

                    statement.executeUpdate();
                    ResultSet result = statement.getGeneratedKeys();

                    if(result.next()) {
                        int insertId = result.getInt(1);
                        try (PreparedStatement req = connection.prepareStatement("SELECT * FROM rooms WHERE id = ?")) {
                            req.setInt(1, insertId);
                            try (ResultSet set = req.executeQuery()) {
                                if(set.next()) {
                                    Emulator.scuti().getRoomManager().getRoomsLoaded().put(set.getInt("id"), new Room(set));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
