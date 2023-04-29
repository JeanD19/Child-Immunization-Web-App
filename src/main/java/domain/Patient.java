package domain;

import static java.util.Calendar.YEAR;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import domain.PatientAddress;
import domain.PatientSex;

public class Patient {
	
	private int outPatientNo;
	private long patientNHISNo;	
	private String patientName;
	private PatientAddress patientAddress;
	private PatientSex patientSex;
	private Date patientDoB;
	
	public Patient(int outPatientNo, Long patientNHISNo, String patientName, PatientAddress patientAddress,
			PatientSex patientSex, Date patientDoB) {
		this.outPatientNo = outPatientNo;
		this.patientNHISNo = patientNHISNo;
		this.patientName = patientName;
		this.patientAddress = patientAddress;
		this.patientSex = patientSex;
		this.patientDoB = patientDoB;
	}
	
	public void setOutPatientNo(int m_outPatientNo) {
		outPatientNo = m_outPatientNo;
	}
	
	public void setPatientNHISNo(int m_patientNHISNo) {
		patientNHISNo = m_patientNHISNo;
	}
	
	public void setPatientName(String m_patientName) {
		patientName = m_patientName;
	}
	
	public void setPatientAddress(PatientAddress m_patientAddress) {
		patientAddress = m_patientAddress;
	}
	
	public void setPatientSex(PatientSex m_patientSex) {
		patientSex = m_patientSex;
	}
	
	public void setPatientDoB(Date m_patientDoB) {
		patientDoB = m_patientDoB;
	}
	
	public int getOutPatientNo() {
		return outPatientNo;
	}
	
	public long getPatientNHISNo() {
		return patientNHISNo;
	}
	
	public String getPatientName() {
		return patientName;
	}
	
	public PatientAddress getPatientAddress() {
		return patientAddress;
	}
	
	public PatientSex getPatientSex() {
		return patientSex;
	}
	
	public Date getPatientDoB() {
		return patientDoB;
	}
	
	public int getPatientAge() {
	    Calendar birth = Calendar.getInstance(Locale.US);
	    birth.setTime(patientDoB);
	    Calendar now = Calendar.getInstance(Locale.US);
	    now.setTime(new java.util.Date());
	    
	    return now.get(YEAR) - birth.get(YEAR);
	}
	@Override
	public String toString() {
		return "Patient{" +
				"outPatientNo=" + outPatientNo +
				", patientNHISNo=" + patientNHISNo +
				", patientName='" + patientName + '\'' +
				", patientAddress=" + patientAddress +
				", patientSex=" + patientSex +
				", patientDoB=" + patientDoB +
				'}';
	}
}
