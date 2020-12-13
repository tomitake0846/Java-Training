package ch05.ex07;

import java.time.LocalDateTime;

public class TimeInterval {

	private LocalDateTime from;
	private LocalDateTime to;

	public TimeInterval(LocalDateTime from, LocalDateTime to) {

		if(!from.isBefore(to)) {
			throw new IllegalArgumentException("your arguments are from >= to. please from < to");
		}

		this.from = from;
		this.to = to;
	}

	public LocalDateTime getFrom() {
		return this.from;
	}

	public LocalDateTime getTo() {
		return this.to;
	}

	public boolean isDuplicated(TimeInterval target) {

		if(this.equals(target)) {
			return true;
		}

		/*
		 * this  :  |----------|
		 *         **duplicated**
		 * target:     |----|
		 */
		if(this.getFrom().isBefore(target.getFrom()) && this.getTo().isAfter(target.getTo())) {
			return true;
		}

		 /*
		 * this   :    |------|
		 *         **duplicated**
		 * target : |-------------|
		 * */
		if(this.getFrom().isAfter(target.getFrom()) && this.getTo().isBefore(target.getTo())) {
			return true;
		}

		/*
		 * this  :  |----|
		 *
		 * target:          |----|
		 * 以下の条件式の対偶を記載
		 * this.getTo().isBefore(target.getFrom())
		 * */

		if(!target.getFrom().isBefore(this.getTo())) {
			return false;
		}

		/*
		 * this  :          |----|
		 *
		 * target:  |----|
		 * 以下の条件式の対偶を記載
		 * target.getTo().isBefore(this.getFrom())
		 * */
		if(!this.getFrom().isBefore(target.getTo())) {
			return false;
		}

		return true;
	}

	// some code regard to event...
//	public void setEvent(Event event) {
//
//	}

	public boolean equals(TimeInterval target) {
		if(target == null) {
			return false;
		}

		if(target == this) {
			return true;
		}

		return this.getTo().equals(target.getTo()) && this.getFrom().equals(target.getFrom());

	}
}
