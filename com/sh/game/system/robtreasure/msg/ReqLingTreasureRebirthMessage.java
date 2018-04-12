package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求灵宝重生</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqLingTreasureRebirthMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLingTreasureRebirthMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50022;
	}
	
	/**
	 * 道具的唯一id
	 */
	private long uniqueId;


	public long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.uniqueId = readLong(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, uniqueId);

		return true;
	}
}
