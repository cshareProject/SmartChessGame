package com.sh.game.system.junxian.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回军衔结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResUpJunXianMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResUpJunXianMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 59002;
	}
	
	/**
	 * 军衔等级
	 */
	private int lv;
	/**
	 * 战力
	 */
	private int fightValue;

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

	
	@Override
	public boolean read(KryoInput buf) {

		this.lv = readInt(buf, false);
		this.fightValue = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, lv, false);
		this.writeInt(buf, fightValue, false);
		return true;
	}
}
