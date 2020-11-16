package com.scuti.messages.incoming.navigator;

import com.scuti.Emulator;
import com.scuti.database.Database;
import com.scuti.messages.incoming.IncomingEvent;
import com.scuti.habbohotel.rooms.Room;
import com.scuti.messages.incoming.rooms.LoadRoomEvent;
import com.scuti.messages.outgoing.Outgoing;
import com.scuti.messages.outgoing.OutgoingMessage;
import com.scuti.messages.outgoing.rooms.LoadRoomMessage;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.*;

public class CreateRoomEvent extends IncomingEvent {
    @Override
    public void handle() throws SQLException, IllegalAccessException, InstantiationException, IOException {
        String name = this.data.getJSONObject("data").getString("roomName");
        int modelId = this.data.getJSONObject("data").getInt("modelId");
        String description = this.data.getJSONObject("data").getString("description");
        //TODO: category system
        int categoryId = this.data.getJSONObject("data").getInt("categoryId");
        int maxUsers = this.data.getJSONObject("data").getInt("maxUsers");


        try(Connection connection = Database.getDB().getConnection()) {

            try(PreparedStatement statement = connection.prepareStatement("INSERT INTO rooms (owner_id, owner_name, name, heightmap, users_max, description) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                //TODO: check max users data
                if(Emulator.scuti().getRoomManager().getModelsLoaded().containsKey(modelId)) {

                    statement.setInt(1, Emulator.scuti().gameClientManager().getClients().get(this.session).getId());
                    statement.setString(2, Emulator.scuti().gameClientManager().getClients().get(this.session).getUsername());
                    statement.setString(3, name);
                    statement.setInt(4, modelId);
                    statement.setInt(5, maxUsers);
                    statement.setString(6, description);

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

                        Class<? extends OutgoingMessage> classMessage = Emulator.scuti().getOutgoingMessageManager().getMessages().get(Outgoing.LoadRoomMessage);
                        OutgoingMessage message = classMessage.newInstance();
                        message.client = this.session;
                        message.data = output;

                        message.compose();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
