package utils;

public class CohenSutherlandComputator  {

    // Area codes
	public static final byte INSIDE = 0; // 0000
	public static final byte LEFT = 1; // 0001
	public static final byte RIGHT = 2; // 0010
	public static final byte BOTTOM = 4; // 0100
	public static final byte TOP = 8; // 1000

    public static byte computeCode(float l, float r, float b, float t, float x, float y) {
		byte code = INSIDE;
		if (x < l) {
			code |= LEFT;
		} else if (x > r) {
			code |= RIGHT;
		}
		// Keep in mind that rect bottom has bigger value in pixels.
		if (y < t) {
			code |= TOP;
		} else if (y > b) {
			code |= BOTTOM;
		}
		return code;
	}
}
