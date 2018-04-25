package com.sh.game.system.treasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.treasure.msg.bean.TreasureBean;

/**
 * <p>返回升级宝物</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResHeroLevelUpTreasureMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeroLevelUpTreasureMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 14017;
	}
	
	/**
	 * 宝物
	 */
	private TreasureBean treasureBean;

	public TreasureBean getTreasureBean() {
		return treasureBean;
	}

	public void setTreasureBean(TreasureBean treasureBean) {
		this.treasureBean = treasureBean;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			TreasureBean treasureBean = new TreasureBean();
			treasureBean.read(buf);
			this.treasureBean = treasureBean;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, treasureBean);
		return true;
	}
}
