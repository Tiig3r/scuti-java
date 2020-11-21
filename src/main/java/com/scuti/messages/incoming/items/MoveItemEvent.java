package com.scuti.messages.incoming.items;

import com.scuti.Emulator;
import com.scuti.habbohotel.items.Item;
import com.scuti.habbohotel.rooms.Room;
import com.scuti.habbohotel.users.User;
import com.scuti.messages.incoming.IncomingEvent;
import com.scuti.messages.outgoing.Outgoing;
import com.scuti.messages.outgoing.OutgoingMessage;

import java.io.IOException;
import java.sql.SQLException;

public class MoveItemEvent extends IncomingEvent {
    @Override
    public void handle() throws SQLException, IllegalAccessException, InstantiationException, IOException {
        Class<? extends OutgoingMessage> classMessage = Emulator.scuti().getOutgoingMessageManager().getMessages().get(Outgoing.MoveItemMessage);
        OutgoingMessage message = classMessage.newInstance();
        message.client = this.session;
        message.data = this.data;
        message.compose();
    }
}
