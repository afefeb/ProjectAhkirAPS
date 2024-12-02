public class Gambar {
    private int imageId;
    private byte[] imageData;

    // Constructor
    public Gambar(int imageId, byte[] imageData) {
        this.imageId = imageId;
        this.imageData = imageData;
    }

    // Getter dan Setter untuk imageId
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    // Getter dan Setter untuk imageData
    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "Gambar{" +
                "imageId=" + imageId +
                ", imageData=" + (imageData != null ? "Byte Array" : "null") +
                '}';
    }
}
