package com.scuti.messages.incoming.navigator;

import com.scuti.Emulator;
import com.scuti.database.Database;
import com.scuti.messages.incoming.IncomingEvent;
import com.scuti.habbohotel.rooms.Room;
import com.scuti.messages.incoming.rooms.LoadRoomEvent;
import com.scuti.messages.outgoing.OutgoingMessage;
import com.scuti.messages.outgoing.rooms.LoadRoomMessage;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.*;

public class CreateRoomEvent extends IncomingEvent {
    @Override
    public void handle() throws SQLException {
        //TODO: refactoring -> reorganisation
        try(Connection connection = Database.getDB().getConnection()) {
            try(PreparedStatement statement = connection.prepareStatement("INSERT INTO rooms (owner_id, name, heightmap, max_users, description) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, Emulator.scuti().gameClientManager().getClients().get(this.session).getId());
                statement.setString(2, this.data.getJSONObject("data").getString("roomName"));

                int modelId = this.data.getJSONObject("data").getInt("modelId");
                int maxUsers = this.data.getJSONObject("data").getInt("maxUsers");
                String description = this.data.getJSONObject("data").getString("description");
                //TODO: check max users data
                if(Emulator.scuti().getRoomManager().getModelsLoaded().containsKey(modelId)) {
                    statement.setInt(3, modelId);
                    statement.setInt(4, maxUsers);
                    statement.setString(5, description);

                    statement.executeUpdate();
                    ResultSet result = statement.getGeneratedKeys();

                    // Insert new room in Hashmap of rooms loaded
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

                        // Go in the room
                        JSONObject output = new JSONObject();
                        output.put("roomId", insertId);
                        OutgoingMessage loadRoomMessage = new LoadRoomMessage();
                        loadRoomMessage.client = this.session;
                        loadRoomMessage.data = output;
                        loadRoomMessage.compose();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
