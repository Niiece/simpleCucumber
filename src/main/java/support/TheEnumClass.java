package support;

import java.util.Arrays;

public class TheEnumClass {

	private final TheEnumClass.THE_ENUM e;

	public TheEnumClass(String phrase) {
		this.e = TheEnumClass.THE_ENUM.getByPhrase(phrase);
	}

	public boolean isTrue() {
		return this.e.getState();
	}

	public String getPhrase() {
		return this.e.getPhrase();
	}

	private enum THE_ENUM {

		SELECTED("selected", true),
		UNSELECTED("unselected", false);

		private String phrase;
		private boolean state;

		THE_ENUM(String phrase, boolean state) {
			this.phrase = phrase;
			this.state = state;
		}

		private boolean getState() {
			return this.state;
		}

		private String getPhrase() {
			return this.phrase;
		}

		private static TheEnumClass.THE_ENUM getByPhrase(String phrase) {
			return Arrays.stream(THE_ENUM.values())
					.filter(e -> e.getPhrase().contains(phrase))
					.findFirst()
					.orElseThrow(IllegalArgumentException::new);
		}

	}

}
