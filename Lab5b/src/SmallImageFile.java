
/* Select image files smaller than 40000 */
public class SmallImageFile implements ISelectImageFile {
 
  /* Return true if the given ImageFile is smaller than 40000 */
  public boolean select(ImageFile f) {
    return f.height * f.width < 40000;
  }
}