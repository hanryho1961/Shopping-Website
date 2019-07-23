package entities;

public class Items {
	private SanPham sanPham;
	private int soLuong;
	
	public Items() {
		this.sanPham = null;
		this.soLuong = 0;
	}
	
	public Items(SanPham sanPham, int soLuong) {
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "Items [sanPham=" + sanPham + ", soLuong=" + soLuong + "]";
	}
	
	
}
