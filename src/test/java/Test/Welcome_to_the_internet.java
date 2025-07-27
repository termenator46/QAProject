package Test;

import Core.TestBase;
import MainPage.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Welcome_to_the_internet extends TestBase {
    Main main;

    @BeforeEach
    public void precondushon(){
        main = new Main(driver);
    }
    @DisplayName("verifiClick")
    @Test
    public void Click_on_Page(){
        main.Clickon_Remove_Elements();
        main.verifiClick("Add/Remove Elements");
    }
    @DisplayName("Verifi add element")
    @Test
    public void Add(){
        main.Clickon_Remove_Elements();
        main.Butten_Add();
        main.Butten_Delete("Delete");
        main.Click_on_Delete();

    }
    @DisplayName("Verifi Clikc check boxes")
    @Test
    public void Boxes(){
        main.Click_on_Check_bokc();
        main.Check_boxes(new String[]{" checkbox 1"," checkbox 2"});
    }
    @DisplayName("Verifi right Click")
    @Test
    public  void  RightClick(){
        main.Clikc_on_Right_box();
        main.veriviRightClick();
    }
    @DisplayName("verivi page Disappearing Elements")
    @Test
    public void Elements(){
        main.Link_Disappearing_Elements();
        main.Clickon_Disappearing_Elements();
        main.verifiClickAbaut();
    }
    @DisplayName("verifi  hold to a to b sector")
    @Test
    public void Drag_and_drop(){
        main.Link_Drag_Drop();
        main.Drag_Drop();
        main.verifi_hold_sector();
    }
    @DisplayName("verifi Slect option")
    @Test
    public  void Drop_List(){
        main.Drop_down_list();
        main.verifi_Clic_koption();
    }
    @DisplayName("verifi Slect option")
    @Test
    public  void Drop_List2(){
        main.List_drop_2();
        main.verifi_Clic_koption();
    }

}
