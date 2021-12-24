package com.harman;

import java.util.Date;


  
import org.springframework.data.annotation.Id;

public class CellularInfo {
	
	@Id
	public int _id;

	private double rsrp;
	
	private double rsrq;
	
	private double snr;
	
	private double pci;
	
	private String phnNo;

	
	private String city;

	
	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	

	public double getRsrp() {
		return rsrp;
	}

	public void setRsrp(double rsrp) {
		this.rsrp = rsrp;
	}

	public double getRsrq() {
		return rsrq;
	}

	public void setRsrq(double rsrq) {
		this.rsrq = rsrq;
	}

	public double getSnr() {
		return snr;
	}

	public void setSnr(double snr) {
		this.snr = snr;
	}

	public double getPci() {
		return pci;
	}

	public void setPci(double pci) {
		this.pci = pci;
	}

	public String getPhnNo() {
		return phnNo;
	}

	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}



	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

	
	
	@Override
	public String toString() {
		return "CellularInfo [_id=" + _id + ", phnNo=" + phnNo + ", city=" + city + "]";
	}
	
	

}
