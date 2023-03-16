package com.darren.center.designpatterns.observer.supper.v1;

/**
 *
 * 写代码实现以下业务场景
 *“小明和小张去中介找房子，小明要3室2厅的房子但租金不要超过6000，小张的要求是租金不超过1500的都能接受。
 * 中介说没问题，你们留个电话，有房子我通知你们”
 */
public class Test {

	public static void main(String[] args) {
		Realtor realtor = new Realtor();
		//添加租客
		new XiaoMing(realtor);
		new XiaoZhang(realtor);

		//添加租房
		realtor.addHouse(new House("张三", "单间", 800));
		realtor.addHouse(new House("李四","一室一厅", 1600));
		realtor.addHouse(new House("李四","三室两厅", 5000));
		realtor.addHouse(new House("赵六","三室两厅", 7000));
		realtor.notifyTenant();
	}

}
