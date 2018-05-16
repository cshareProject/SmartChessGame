package com.sh.game.system.battle.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class HurtDataBean extends KryoBean {

	/**
	 * id
	 */
	private long targetId;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 伤害
	 */
	private long hp;
	/**
	 * 增加的buff列表
	 */
	private List<BufferAdd> bufferList = new ArrayList<>();

	public long getTargetId() {
		return targetId;
	}

	public void setTargetId(long targetId) {
		this.targetId = targetId;
	}

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		public long getHp() {
		return hp;
	}

	public void setHp(long hp) {
		this.hp = hp;
	}

		public List<BufferAdd> getBufferList() {
		return bufferList;
	}

	public void setBufferList(List<BufferAdd> bufferList) {
		this.bufferList = bufferList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.targetId = readLong(buf);
		this.name = readString(buf);
		this.hp = readLong(buf);
		int bufferListLength = readShort(buf);
		for (int bufferListI = 0; bufferListI < bufferListLength; bufferListI++) {
			if (readByte(buf) == 0) { 
				this.bufferList.add(null);
			} else {
				BufferAdd bufferAdd = new BufferAdd();
				bufferAdd.read(buf);
				this.bufferList.add(bufferAdd);
			}
		}
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, targetId);
		this.writeString(buf, name);
		this.writeLong(buf, hp);
		writeShort(buf, this.bufferList.size());
		for (int bufferListI = 0; bufferListI < this.bufferList.size(); bufferListI++) {
			this.writeBean(buf, this.bufferList.get(bufferListI));
		}
		return true;
	}
}