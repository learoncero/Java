/**
 * Uebungsblatt 3
 * Aufgabe 3: Verwalten von Messwerten
 * 
 * Autor: Lea Roncero
 * Datum: 30.03.2023
 * 
 * 
 */

package at.fhv.itb.lro3572;

import java.util.LinkedList;

public class ProbeManager {
	public final static int DEFAULT_SIZE = 10;
	private LinkedList<Probe> _probes = new LinkedList<Probe>();;
	private int _buffer;
	
//	Start Constructors
	public ProbeManager(int buffer) {
		_buffer = buffer;
	}
	
	public ProbeManager() {
		this(DEFAULT_SIZE);
	}
//	End Constructors
	
//	Start Getter and Setter
	public LinkedList<Probe> get_probes() {
		return _probes;
	}

	public void setProbes(LinkedList<Probe> probes) {
		_probes = probes;
	}

	public int getBuffer() {
		return _buffer;
	}

	public void setBuffer(int buffer) {
		_buffer = buffer;
	}

	public static int getDefaultSize() {
		return DEFAULT_SIZE;
	}
//	End Getter and Setter

//	Start Methods
	public void add(Probe p) {
		if (_probes.size() < _buffer) {
			_probes.add(p);
		}
		else {
			_probes.remove(0);
			_probes.add(p);
		}
	}
	
	public void reset() {
		_probes.clear();
	}
	
	public void outputProbes() {
		System.out.println(_probes.toString());
	}
	
	public Probe getMaxTemperature() {
		Probe maxTemp = _probes.get(0);
		for (int i = 1; i < _probes.size(); i += 1) {
			if (_probes.get(i).getTemperature() > maxTemp.getTemperature()) {
				maxTemp = _probes.get(i);
			}
		}
		return maxTemp;
	}
	
	public Probe getMinTemperature() {
		Probe minTemp = _probes.get(0);
		for (int i = 1; i < _probes.size(); i += 1) {
			if (_probes.get(i).getTemperature() < minTemp.getTemperature()) {
				minTemp = _probes.get(i);
			}
		}
		return minTemp;
	}
	
	public double getMean(int startPeriod, int endPeriod) {
		double mean = 0;
		if ((startPeriod > 0) && (startPeriod <= endPeriod) && (startPeriod <= _probes.size()) && 
				(endPeriod <= _probes.size())){
			for (int i = startPeriod - 1; i < endPeriod; i += 1) {
				mean += _probes.get(i).getTemperature();
			}
			mean = mean / ((endPeriod - startPeriod) + 1);
			return mean;
		}
		else {
			return -100.0;
		}
	}
//	End Methods

	@Override
	public String toString() {
		return "ProbeManager [_probes=" + _probes + ", _buffer=" + _buffer + ", get_probes()=" + get_probes()
				+ ", getBuffer()=" + getBuffer() + ", getMaxTemperature()=" + getMaxTemperature()
				+ ", getMinTemperature()=" + getMinTemperature() + "]";
	}

	public static void main(String[] args) {
		Probe p1 = new Probe(12.3, 12);
		Probe p2 = new Probe(13.2, 13);
		Probe p3 = new Probe(15.1, 14);
		Probe p4 = new Probe(15.5, 15);
		Probe p5 = new Probe(14.7, 16);
		Probe p6 = new Probe(14.2, 17);
		ProbeManager probeManager = new ProbeManager(5);
		probeManager.add(p1);
		probeManager.add(p2);
		probeManager.add(p3);	
		probeManager.add(p4);	
		probeManager.add(p5);	
		
		probeManager.outputProbes();
		
		System.out.println("Max. Temperature: " + probeManager.getMaxTemperature());
		System.out.println("Min. Temperature: " + probeManager.getMinTemperature());
		System.out.println("Mean 2nd to 5th probe: " + probeManager.getMean(2, 8) + "°C");
		
		probeManager.add(p6);
		probeManager.outputProbes();
		
		probeManager.reset();
		
		System.out.print("ProbeManager after reset: ");
		probeManager.outputProbes();
	}
}
