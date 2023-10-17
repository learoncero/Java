/**
 * Uebungsblatt 3
 * Aufgabe 2: Ein Fall fürs Standesamt
 * 
 * Autor: Lea Roncero
 * Datum: 30.03.2023
 * 
 * 
 */

package at.fhv.itb.lro3572;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	private String _fName;
	private String _lName;
	private Gender _gender;
	private LocalDate _dateOfBirth;
	private Person _partner;
	private Person _witness1;
	private Person _witness2;
	private boolean _married;
	private String _girlsName;
	private String _reasonForDivorce;
	
	public enum Gender {
		male,
		female;
	}
	
	public Person (String firstName, String lastName, Gender gender, LocalDate dateOfBirth) {
		_fName = firstName;
		_lName = lastName;
		_gender = gender;
		_dateOfBirth = dateOfBirth;
		_partner = null;
		_witness1 = null;
		_witness2 = null;
		_married = false;
		_girlsName = "";
		_reasonForDivorce = "";
	}
	
	public String marry(Person p, Person witness1, Person witness2) {
		LocalDate today = LocalDate.now();
		int ageP1 = Period.between(_dateOfBirth, today).getYears();
		int ageP2 = Period.between(p ._dateOfBirth, today).getYears();
		int ageW1 = Period.between(witness1._dateOfBirth, today).getYears();
		int ageW2 = Period.between(witness2._dateOfBirth, today).getYears();
		if ((_married == false) && (p._married == false) && (_gender != p._gender) 
				&& (ageP1 >= 18) && (ageP2 >= 18) && (ageW1 >= 18) && (ageW2 >= 18)) {
			_partner = p;
			p._partner = this;
			_witness1 = witness1;
			_witness2 = witness2;
			p._witness1 = witness1;
			p._witness2 = witness2;
			
			_married = true;
			p._married = true;
			
			if (_gender == Gender.female) {
				_girlsName = _lName;
				_lName = p._lName;
			}
			else {
				p._girlsName = p._lName;
				p._lName = _lName;
			}
			return "The marriage was successfully registered in the system.";
		}
		else if (_married == true) {
			return "The person is/has already been maaried!";
		}
		else if (p._married == true) {
			return "The partner is/has already been married!";
		}
		else if (_gender == p._gender) {
			return "Same gender!";
		}
		else if (ageP1 < 18) {
			return "The person is too young!";
		}
		else if (ageP2 < 18) {
			return "The partner is too young!";
		}
		else if (ageW1 < 18) {
			return "The witness1 is too young!";
		}
		else {
			return "The witness2 is too young!";
		}
	}
	
	public String divorce(Person p, String reason) {
		if (_partner == p) {
			_partner = null;
			p._partner = null;
			_reasonForDivorce = reason;
			p._reasonForDivorce = reason;
			_witness1 = null;
			_witness2 = null;
			p._witness1 = null;
			p._witness2 = null;
			
			if (_gender == Gender.female) {
				_lName = _girlsName;
				_girlsName = "";
			}
			else {
				p._lName = p._girlsName;
				p._girlsName = "";
			}
			return "The divorce was successfully registered in the system.";
		}
		else {
			return "The persons are not married to each other!";
		}
	}

	@Override
	public String toString() {
		return "Person [_fName=" + _fName + ", _lName=" + _lName + ", _dateOfBirth="
				+ _dateOfBirth + ", _partner=" + _partner + ", _witness1=" + _witness1 + ", _witness2=" + _witness2
				+ ", _married=" + _married + ", _girlsName=" + _girlsName + ", _reasonForDivorce=" + _reasonForDivorce
				+ "]";
	}

	public static void main(String[] args) {
		Person donald = new Person("Donald", "Duck", Gender.male, LocalDate.of(2003, 6, 18));
		Person daisy = new Person("Daisy", "Flower", Gender.female, LocalDate.of(2002, 4, 2));
		Person wit1 = new Person("Ronald", "Ruck", Gender.male, LocalDate.of(2023, 12, 5));
		Person wit2 = new Person("Laisy", "Locko", Gender.female, LocalDate.of(1992, 8, 27));
		
		String resultMarriage = donald.marry(daisy, wit1, wit2);
		String resultDivorce = daisy.divorce(donald, "Fremdgehen");
		System.out.println("Marriage Donald/Daisy: " + resultMarriage);
		System.out.println("Divorce Donald/Daisy: " + resultDivorce);
	}
}
