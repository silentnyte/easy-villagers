package de.maxhenkel.corelib.net;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

public interface Message<T extends Message> {

    Dist getExecutingSide();

    default void executeServerSide(NetworkEvent.Context context) {

    }

    default void executeClientSide(NetworkEvent.Context context) {

    }

    T fromBytes(FriendlyByteBuf buf);

    void toBytes(FriendlyByteBuf buf);

}
