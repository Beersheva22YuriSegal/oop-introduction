package telran.shapes;

public class Canvas extends Shape {
	
	private Shape[] shapes;
	private String direction = "row";
	private int margin = 5;


	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getMargin() {
		return margin;
	}
	
	public void setMargin(int margin) {
		this.margin = margin;
	}
	
	public Canvas(int width, int height, Shape[] shapes) {
		super(width, height);
		this.shapes = shapes;
	}

	@Override
	public String[] presentation(int offset) {
		switch(direction) {
		case ("row"):
			return getHorizontalPresentation(offset);
		case ("column"):
			return getVerticalPresentation(offset);
		}
		return null;
	}

	
	private String[] getVerticalPresentation(int offset) {
		int canvasHeight = getVerticalCanvasHeight();
		String[] res = new String[canvasHeight];
		int sup = 0;
		for (int i = 0; i < shapes.length - 1; i++) {
			String[] helper = shapes[i].presentation(offset);
			addVerticalArr(sup, res, helper);
			addVerticalMargin(sup + helper.length, offset, res);
			sup += helper.length + margin;
		}
		addVerticalArr(sup, res, shapes[shapes.length - 1].presentation(offset));
		return res;
	}

	private void addVerticalMargin(int i, int offset, String[] res) {
		int width = getWidth() + offset;
		for (int j = i; j < i + margin; j++) {
			res[i] = " ".repeat(width);
		}
	}

	private void addVerticalArr(int sup, String[] res, String[] helper) {
		System.arraycopy(helper, 0, res, sup, helper.length);
		
	}

	private int getVerticalCanvasHeight() {
		int res = shapes[0].presentation(0).length;
		for (int i = 1; i < shapes.length; i++) {
			res += shapes[i].presentation(0).length + margin;
		}
		return res;
	}

	private String[] getHorizontalPresentation(int offset) {
		int height = getHeight();
		shapes[0].setHeight(height);
		String[] res = shapes[0].presentation(offset);
		for (int i = 1; i < shapes.length; i++) {
			shapes[i].setHeight(height);
			res = joinArrays(res, shapes[i].presentation(margin));
		}
		return res;
	}

	private static String[] joinArrays(String[] array1, String[] array2) {
		String result[] = new String[array1.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = array1[i] + array2[i];
		}
		return result;
	}
}
