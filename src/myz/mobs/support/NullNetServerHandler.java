/**
 * 
 */
package myz.mobs.support;

import net.minecraft.server.v1_6_R3.EntityPlayer;
import net.minecraft.server.v1_6_R3.INetworkManager;
import net.minecraft.server.v1_6_R3.MinecraftServer;
import net.minecraft.server.v1_6_R3.Packet;
import net.minecraft.server.v1_6_R3.Packet102WindowClick;
import net.minecraft.server.v1_6_R3.Packet106Transaction;
import net.minecraft.server.v1_6_R3.Packet10Flying;
import net.minecraft.server.v1_6_R3.Packet130UpdateSign;
import net.minecraft.server.v1_6_R3.Packet14BlockDig;
import net.minecraft.server.v1_6_R3.Packet15Place;
import net.minecraft.server.v1_6_R3.Packet16BlockItemSwitch;
import net.minecraft.server.v1_6_R3.Packet255KickDisconnect;
import net.minecraft.server.v1_6_R3.Packet28EntityVelocity;
import net.minecraft.server.v1_6_R3.Packet3Chat;
import net.minecraft.server.v1_6_R3.Packet51MapChunk;
import net.minecraft.server.v1_6_R3.PlayerConnection;

/**
 * @author kumpelblase2
 * 
 */
public class NullNetServerHandler extends PlayerConnection {
	public NullNetServerHandler(MinecraftServer minecraftserver, INetworkManager inetworkmanager, EntityPlayer entityplayer) {
		super(minecraftserver, inetworkmanager, entityplayer);
	}

	@Override
	public void a(Packet102WindowClick packet) {
	}

	@Override
	public void a(Packet106Transaction packet) {
	}

	@Override
	public void a(Packet10Flying packet) {
	}

	@Override
	public void a(Packet130UpdateSign packet) {
	}

	@Override
	public void a(Packet14BlockDig packet) {
	}

	@Override
	public void a(Packet15Place packet) {
	}

	@Override
	public void a(Packet16BlockItemSwitch packet) {
	}

	@Override
	public void a(Packet255KickDisconnect packet) {
	}

	@Override
	public void a(Packet28EntityVelocity packet) {
	}

	@Override
	public void a(Packet3Chat packet) {
	}

	@Override
	public void a(Packet51MapChunk packet) {
	}

	@Override
	public void a(String string, Object[] objects) {
	}

	@Override
	public void sendPacket(Packet packet) {
	}
}
