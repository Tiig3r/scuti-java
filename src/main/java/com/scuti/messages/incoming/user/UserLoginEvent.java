package com.scuti.messages.incoming.user;

import com.scuti.Emulator;
import com.scuti.database.Database;
import com.scuti.messages.incoming.IncomingEvent;
import com.scuti.messages.outgoing.Outgoing;
import com.scuti.messages.outgoing.OutgoingMessage;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.*;

public class UserLoginEvent extends IncomingEvent {
    @Override
    public void handle() throws SQLException {
        // TODO: make sure the connection with SSO/Token
        String username = this.data.getJSONObject("data").getString("username");
        try(Connection connection = Database.getDB().getConnection()) {
            try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?")) {
                statement.setString(1, username);
                try(ResultSet set = statement.executeQuery()) {
                    if(set.next()) {
                        JSONObject output = new JSONObject();
                        output.put("username", username);

                        Emulator.scuti().getUserManager().loadHabbo(set, this.session);

                        Class<? extends OutgoingMessage> classMessage = Emulator.scuti().getOutgoingMessageManager().getMessages().get(Outgoing.UserLoginMessage);
                        OutgoingMessage message = classMessage.newInstance();
                        message.client = this.session;
                        message.data = output;

                        message.compose();
                    } else {
                        System.out.println(username.concat(" doesn't exist!"));
                    }
                } catch (IllegalAccessException | InstantiationException | IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.out.println(Emulator.ERROR + "[UserLoginEvent] Cannot execute request!");
        }
    }
}
