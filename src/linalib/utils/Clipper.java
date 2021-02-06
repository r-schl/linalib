package utils;

import vec.Vec2;


public class Clipper {


    // Area codes
	public static final byte INSIDE = 0; // 0000
	public static final byte LEFT = 1; // 0001
	public static final byte RIGHT = 2; // 0010
	public static final byte BOTTOM = 4; // 0100
	public static final byte TOP = 8; // 1000

    private static byte computeRegionCode(float xmin, float xmax, float ymin, float ymax, float x, float y) {
		byte code = INSIDE;
		if (x < xmin) {
			code |= LEFT;
		} else if (x > xmax) {
			code |= RIGHT;
		}
		if (y < ymin) {
			code |= BOTTOM;
		} else if (y > ymax) {
			code |= TOP;
		}
		return code;
	}


    /**
     * This method uses the Cohen Sutherland algorithm clip a line given by 2 points in 2D.
     * 
     * @param xmin 
     * @param xmax
     * @param ymin
     * @param ymax
     * @param p0
     * @param p1
     * @param res0
     * @param res1
     * @return
     */
	public static boolean clip2d(float xmin, float xmax, float ymin, float ymax, Vec2 p0, Vec2 p1, Vec2 res0, Vec2 res1) {

		float x0 = p0.x;
		float y0 = p0.y;
		float x1 = p1.x;
		float y1 = p1.y;

		// compute area codes for both points
		byte code0 = computeRegionCode(xmin, xmax, ymin, ymax, p0.x, p0.y);
		byte code1 = computeRegionCode(xmin, xmax, ymin, ymax, p1.x, p1.y); 

		boolean accept = false;

		while (true) {
			if ((code0 | code1) == INSIDE) {
				// both endpoints lie within rectangle
				accept = true;
				System.out.println("inside");
				break;
			} else if ((code0 & code1) != INSIDE) { 
				// If both endpoints are outside rectangle, in same region
				System.out.println("outside");
				break;
			} else {
				// Some segment of line lies within the rectangle 
				// At least one end-point is outside the clip rectangle; pick it.
				final byte outCode = (code0 != INSIDE) ? code0 : code1;
				// Find the intersection point clip x/y;
				final float clipX;
				final float clipY;
				// Use formulas y = y0 + slope * (x - x0), x = x0 + (1 / slope) * (y - y0)
				if ((outCode & TOP) != INSIDE) {
					// Point is above the clip rectangle
					clipX = x0 + (x1 - x0) * (ymax - y0) / (y1 - y0);
					clipY = ymax;
				} else if ((outCode & BOTTOM) != INSIDE) {
					// Point is below the clip rectangle.
					clipX = x0 + (x1 - x0) * (ymin - y0) / (y1 - y0);
					clipY = ymin;
				} else if ((outCode & RIGHT) != INSIDE) {
					// Point is to the right of clip rectangle.
					clipY = y0 + (y1 - y0) * (xmax - x0) / (x1 - x0);
					clipX = xmax;
				} else if ((outCode & LEFT) != INSIDE) {
					// Point is to the left of clip rectangle.
					clipY = y0 + (y1 - y0) * (xmin - x0) / (x1 - x0);
					clipX = xmin;
				} else {
					clipX = Float.NaN;
					clipY = Float.NaN;
				}

				// replace point outside the rectangle with the intersection point (clipX, clipY)
				if (outCode == code0) {
					x0 = clipX;
					y0 = clipY;
					code0 = computeRegionCode(xmin, xmax, ymin, ymax, x0, y0);
				} else {
					x1 = clipX;
					y1 = clipY;
					code1 = computeRegionCode(xmin, xmax, ymin, ymax, x1, y1);
				}
			}
		}

		// finished
		res0.x = x0;
		res0.y = y0;
		res1.x = x1;
		res1.y = y1;

		return accept;
	}
    
    
}
