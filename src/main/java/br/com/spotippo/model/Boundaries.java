package br.com.spotippo.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Embeddable
public class Boundaries {
	
	/*
	 * A área total de Spotippos é definida da seguinte forma 0 <= x <= 1400 e 0 <= y <= 1000
	*/
	@Embedded
	private UpperLeft upperLeft;
	
	@Embedded
	private BottomRight bottomRight;
	
	public UpperLeft getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(UpperLeft upperLeft) {
		this.upperLeft = upperLeft;
	}

	public BottomRight getBottomRight() {
		return bottomRight;
	}

	public void setBottomRight(BottomRight bottomRight) {
		this.bottomRight = bottomRight;
	}
	
	@Embeddable
	public static class UpperLeft {
		
		@Column(name="upperLeftX")
		@NotNull
		@Min(0)
		@Max(1400)
		private Integer x;
	
		@Column(name="upperLeftY")
		@NotNull
		@Min(0)
		@Max(1000)
		private Integer y;

		public Integer getX() {
			return x;
		}

		public void setX(Integer x) {
			this.x = x;
		}

		public Integer getY() {
			return y;
		}

		public void setY(Integer y) {
			this.y = y;
		}
		
	}
	
	@Embeddable
	public static class BottomRight {
		
		@Column(name="bottomRightX")
		@NotNull
		@Min(0)
		@Max(1400)
		private Integer x;
	
		@Column(name="bottomRightY")
		@NotNull
		@Min(0)
		@Max(1000)
		private Integer y;

		public Integer getX() {
			return x;
		}

		public void setX(Integer x) {
			this.x = x;
		}

		public Integer getY() {
			return y;
		}

		public void setY(Integer y) {
			this.y = y;
		}
		
	}
}
