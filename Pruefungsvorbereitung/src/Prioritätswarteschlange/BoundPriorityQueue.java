package Prioritätswarteschlange;

import java.util.Arrays;

public class BoundPriorityQueue {
	private Job[] _jobs;
 	private int[] _priorities;
	private int _entries;

	public BoundPriorityQueue(int size) {
		_jobs = new Job[size];
		_priorities = new int[size];
		_entries = 0;
	}

	public void set(Job job, int priority) throws PrioTooLowException {
		if (_entries < _jobs.length) {	
			int i;
			for(i = 0; ((i < _jobs.length) && (_jobs[i] != null)); i += 1) {
			}
			_jobs[i] = job;
			_priorities[i] = priority;
			_entries += 1;
		}
		else {
			int lowestPrio = 10;
			int lowestPrioIndex = -1;
			for (int i = 0; i < _jobs.length; i += 1) {
				if (_priorities[i] < priority) {
					if (_priorities[i] <= lowestPrio) {
						lowestPrioIndex = i;
					}
				}
			}
			if (lowestPrioIndex != -1) {
				_jobs[lowestPrioIndex] = job;
				_priorities[lowestPrioIndex] = priority;
			}
			else {
				throw new PrioTooLowException("Die Warteschlange ist voll und die Priorität dieses Jobs zu gering!");
			}
		}
	}

	public Job getHighest() {
		int highestPrio = 0;
		int highestPrioIndex = -1;

		for(int i = 0; i < _priorities.length; i += 1) {
			if (_priorities[i] > highestPrio) {
				highestPrio = _priorities[i];
				highestPrioIndex = i;
			}
		}
		Job output = _jobs[highestPrioIndex];
		_jobs[highestPrioIndex] = null;	
		_entries -= 1;
		return output;
	}
	
	@Override
	public String toString() {
		return "BoundPriorityQueue [_jobs=" + Arrays.toString(_jobs) + ", _priorities=" + Arrays.toString(_priorities)
				+ ", _index=" + _entries + "]";
	}

	public static void main(String[] args) {
		Job j1 = new Job(1, "Job 1");
		Job j2 = new Job(2, "Job 2");
		Job j3 = new Job(3, "Job 3");
		Job j4 = new Job(4, "Job 4");
		Job j5 = new Job(5, "Job 5");
		
		BoundPriorityQueue queue = new BoundPriorityQueue(5);
		try {
			queue.set(j1, 8);
			queue.set(j2, 2);
			queue.set(j3, 2);
			queue.set(j4, 10);
			queue.set(j5, 8);
		} catch (PrioTooLowException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(queue);
		
		Job j6 = new Job(6, "Job 6");
		try {
			queue.set(j6, 9);
		} catch (PrioTooLowException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(queue);
		System.out.println(queue.getHighest());
	}
}
