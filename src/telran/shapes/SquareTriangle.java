package telran.shapes;

public class SquareTriangle extends Square {
	private boolean isLeftDiagonal = false;

	protected SquareTriangle(int size, boolean isLeftDiagonal) {
		super(size);
		this.isLeftDiagonal = isLeftDiagonal;
	}

	public String[] presentation(int offset) {
		int size = getHeight();
		String[] res = new String[size];
		res[0] = getFirstLine(offset);
		String line = getLine(offset);
		int lastLine = size - 1;
		res[lastLine] = line;
		for (int i = 1; i < lastLine; i++) {
			res[i] = getMiddleLine(offset, i);
		}
		return res;
	}

	private String getMiddleLine(int offset, int i) {

		return isLeftDiagonal ? getOffset(offset) + getSymbol() + getOffset(i - 1) + getSymbol()
				: getOffset(offset + getWidth() - i - 1) + getSymbol() + getOffset(i - 1) + getSymbol();
	}

	private String getFirstLine(int offset) {
		return isLeftDiagonal ? getOffset(offset) + getSymbol() : getOffset(offset + getWidth() - 1) + getSymbol();
	}

}
