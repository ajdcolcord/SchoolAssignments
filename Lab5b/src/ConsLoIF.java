
// Represents a nonempty list of ImageFiles
public class ConsLoIF implements ILoIF {

  public ImageFile first;
  public ILoIF rest;

  public ConsLoIF(ImageFile first, ILoIF rest) {
    this.first=first;
    this.rest=rest;
  }

  // Does this nonempty list contain that ImageFile   
  public boolean contains(ImageFile that) { 
    return (this.first.sameImageFile(that) ||
            this.rest.contains(that));
  }
  
  //filterSmallerThan40000
  public ILoIF filterSmallerThan40000() {
      if (this.first.size() < 40000) {
          return (new ConsLoIF(this.first, this.rest.filterSmallerThan40000()));
      }
      else {
          
      }
  }
}
