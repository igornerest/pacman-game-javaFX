package engine;

import java.io.FileInputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Tile {

	private ImageView tileImage;

	// method may throw an exception if the source of the Image is wrong
	public Tile(String imgSource, int x, int y) throws Exception {
	
		try (FileInputStream fileStream = new FileInputStream(imgSource)) {
			// setting image according to source of the file
			this.tileImage = new ImageView(new Image(fileStream));
			// setting x and y positions
			this.tileImage.setX(x * Preferences.TILE_SIZE);
			this.tileImage.setY(y * Preferences.TILE_SIZE);
			this.tileImage.setPreserveRatio(true);
			this.tileImage.setFitHeight(Preferences.TILE_SIZE);
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	// reinforcing good encapsulation 
	public ImageView getTileImageView () {
		return this.tileImage;
	}
}