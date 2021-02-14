package com.hrullo.examen.persistencia.entidades;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Entity
@Table(name="beancsv")
@Data
public class BeanCsv implements Comparable<BeanCsv>{
	
	
	@Column(name="REGION")
	private String region;

	@Column(name="COUNTRY")
	private String country;

	@Column(name="ITEMTYPE")
	private String itemType;
	
	@Column(name="SALESCHANNELS")
	private String salesChannel;

	@Column(name = "ORDERPRIORITY")
	private String orderPriority;
	
	@Column(name="ORDERDATE")
	private String orderDate;
	
	@Id
	@Column(name="ORDERID")
	private int orderId;
	
	@Column(name="SHIPDATE")
	private String shipDate;
	
	@Column(name="UNITSSOLD")
	private float unitsSold;
	
	@Column(name="UNITPRICE")
	private float unitPrice;
	
	@Column(name="UNITCOST")
	private float  unitCost;
	
	@Column(name = "TOTALREVENUE")
	private float totalRevenue;
	
	@Column(name = "TOTALCOAST")
	private float totalCost;

	@Column(name = "TOTALPROFIT")
	private float totalProfit;
	
	
	@Override
	public String toString() {
		return "BeanCsv [region=" + region + ", country=" + country + ", itemType=" + itemType + ", salesChannel="
				+ salesChannel + ", orderPriority=" + orderPriority + ", orderDate=" + orderDate + ", orderId="
				+ orderId + ", shipDate=" + shipDate + ", unitsSold=" + unitsSold + ", unitPrice=" + unitPrice
				+ ", unitCost=" + unitCost + ", totalRevenue=" + totalRevenue + ", totalCost=" + totalCost
				+ ", totalProfit=" + totalProfit + "]";
	}


	@Override
	public int compareTo(BeanCsv o) {
		 if (orderId < o.getOrderId()) {
             return -1;
         }
         if (orderId > o.getOrderId()) {
             return 1;
         }
         return 0;
	}
	
	
}
