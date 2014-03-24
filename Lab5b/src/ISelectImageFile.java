// to represent a predicate for ImageFile-s
public interface ISelectImageFile{
 
  // Return true if the given ImageFile
  // should be selected
  public boolean select(ImageFile f);
}