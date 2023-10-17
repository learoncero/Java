package Prioritätswarteschlange;

public class Job {
	private int _id;
	private String _name;
	
	public Job(int id, String name) {
		_id = id;
		_name = name;
	}

	@Override
	public String toString() {
		return "Job [_id=" + _id + ", _name=" + _name + "]";
	}
}
