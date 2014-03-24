import edu.neu.ccs.gui.*;
import edu.neu.ccs.util.*;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A view for input and manipulation of a Balloon object.
 * 
 * @since 31 March 2010
 * @author Viera K. Proulx
 */
public class BalloonInputView extends Display
implements JPTConstants {

    /** Display field for the x coordinate of the center. */
    protected TextFieldView xTFV;

    /** Display field for the y coordinate of the center. */
    protected TextFieldView yTFV;

    /** Display field for the r */
    protected TextFieldView rTFV;

    /** The slider in the GUI that controls radius. */
    protected SliderView rSlider;

    /** The view in the GUI that displays the color. */
    protected ColorView cView;


    /** The constructor */
    public BalloonInputView() {
        super();

        // add the internal panel to the Display
        add(createDisplay());

        // set the title and annotation for the Display
        setTitleText("Balloon");
    }
    
    /** The cancel action. */
    protected SimpleAction rSliderAction =
            new SimpleAction("Cancel") {
        public void perform() { rSliderAction(); }
    };
    

    //////////////////////////////////
    // Helpers for the Constructors //
    //////////////////////////////////

    /**
     * Construct a table panel display for one balloon, containing
     * three text field views, sliders, and color view
     */
    protected TablePanel createDisplay() {

        createViews();

        TablePanel balloonDisplay = new TablePanel(new Object[][]{
                {"X:", this.xTFV},
                {"Y:", this.yTFV},
                {"R:", this.rTFV},
                {"R:", this.rSlider},
                {"Color:", this.cView}},
                VERTICAL, 5, 5);

        return balloonDisplay;        	
    }

    /**
     * Creates three text field views with the desired default values
     * a ColorView, and three Sliders
     */
    protected void createViews() {

        // the TFV for the x coordinate of the center
        this.xTFV = new TextFieldView(
                "" + 100,						               // default value
                "Please enter a real number:",     // error prompt
                "x coordinate error",			         // error message
                80);							                 // field width

        // the TFV for the y coordinate of the center
        this.yTFV = new TextFieldView(
                "" + 200,
                "Please enter a real number:",
                "y coordinate error",
                80);

        // the TFV for the r
        this.rTFV = new TextFieldView(
                "" + 20,
                "Please enter a real number:",
                "r error",
                80);

        // the slider for the radius size
        this.rSlider = new SliderView(HORIZONTAL, 0, 80, 50);

        // the ColorView to select the color
        this.cView = new ColorView(Color.red, true);

        // define the defaults
        this.xTFV.setDefaultViewState("" + 100);
        this.yTFV.setDefaultViewState("" + 200);	

        this.rTFV.addActionListener(rTFVaction);
        this.rSlider.addSlidingAction(rSliderAction);

    }

    /**
     * Produce a <code>Balloon</code> with values extracted from this
     * <code>BalloonInputView</code>
     */
    public Balloon demandBalloon(){
        return new Balloon( this.xTFV.demandInt(),
                this.yTFV.demandInt(),
                this.rSlider.getValue(),
                this.cView.getColor());
    }

    /**
     * Construct a modal dialog with the <code>BalloonInputView</code>, then
     * produce a <code>Balloon</code> with values extracted from this
     * <code>BalloonInputView</code>
     */
    public static Balloon demandOneBalloon(){
        BalloonInputView bGUI = new BalloonInputView();
        GeneralDialog.showOKDialog(bGUI, "Balloon Input");
        return bGUI.demandBalloon();
    }

    /**
     * Produce a <code>Balloon</code> with values extracted from this
     * <code>BalloonInputView</code> --- with the CANCEL option
     * 
     */
    public Balloon requestBalloon() throws CancelledException{
        return new Balloon( this.xTFV.requestInt(),
                this.yTFV.requestInt(),
                this.rSlider.getValue(),
                this.cView.getColor());
    }

    /**
     * Construct a modal dialog with the <code>BalloonInputView</code>, then
     * produce a <code>Balloon</code> with values extracted from this
     * <code>BalloonInputView</code> --- with the CANCEL option
     */
    public static Balloon requestOneBalloon() throws CancelledException{
        BalloonInputView bGUI = new BalloonInputView();
        GeneralDialog.showOKCancelDialog(bGUI, "Balloon Input");
        return bGUI.requestBalloon();
    }

    /** Set the state of the slider to the number displayed in the rTFV */
    public void rTFVaction() {
        rSlider.setViewState("" + rTFV.getViewState());

    } 

    /** Set the state of the number displayed in the rTFV to what the
     * slider is set to
     */
    public void rSliderAction() {
        rTFV.setViewState("" + rSlider.getViewState());
    }

}