package com.sh.game.system.junxian.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回军衔信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResJunXianInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResJunXianInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 59003;
	}
	
	/**
	 * 军衔等级
	 */
	private int lv;
	/**
	 * 战力
	 */
	private int fightValue;
	/**
	 * 已领取次数
	 */
	private int hasDrawCount;
	/**
	 * 上一次领取时间(s)
	 */
	private int lastDrawTime;

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

		public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

		public int getHasDrawCount() {
		return hasDrawCount;
	}

	public void setHasDrawCount(int hasDrawCount) {
		this.hasDrawCount = hasDrawCount;
	}

		public int getLastDrawTime() {
		return lastDrawTime;
	}

	public void setLastDrawTime(int lastDrawTime) {
		this.lastDrawTime = lastDrawTime;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.lv = readInt(buf, false);
		this.fightValue = readInt(buf, false);
		this.hasDrawCount = readInt(buf, false);
		this.lastDrawTime = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, lv, false);
		this.writeInt(buf, fightValue, false);
		this.writeInt(buf, hasDrawCount, false);
		this.writeInt(buf, lastDrawTime, false);
		return true;
	}
}
