package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送累计登录信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendTotalLoginDayMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendTotalLoginDayMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4019;
	}
	
	/**
	 * 活动id
	 */
	private int activityId;
	/**
	 * 累计登录天数
	 */
	private int num;

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

		public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.activityId = readInt(buf, false);
		this.num = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, activityId, false);
		this.writeInt(buf, num, false);
		return true;
	}
}