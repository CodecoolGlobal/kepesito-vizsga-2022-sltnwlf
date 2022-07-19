import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeleniumTest extends TestBase {

    /*
    Tölts be a böngészőbe az alábbi oldalt: https://demo.seleniumeasy.com/basic-first-form-demo.html
    Írj tesztesetet két szám összegének ellenőrzésére a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet.
    Az oldalon, a Two Input Fields” szekcióban két beviteli mezőjét töltsd ki tetszőleges számokkal,
    majd végezd el a számok összeadásának ellenőrzését kiolvasva az oldalon megjelenő összeget.
    Használj tetszőleges tesztadatot
     */
    @Test
    @DisplayName("TC1")
    public void TestInput()
    {
        base.popupKiller();
        input.navigate();
        input.fillAllInputs("5","6");
        String expected = "11";
        String actual = input.getResultText();
        Assertions.assertEquals(expected,actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/basic-select-dropdown-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet a következők szerint:
    a Select List Demo szekció lenyíló mezőjében válaszd ki a hét utolsó napját és ellenőrizd,
    hogy az oldalon helyesen jelenik meg a kiválasztott érték
    Tesztadatként használd az hét utolsó napját
     */
    @Test
    @DisplayName("TC2")
    public void SelectDayTest()
    {
        base.popupKiller();
        selectDay.navigate();
        selectDay.selectDropdown("Sunday");
        String expected = "Sunday";
        String actual = selectDay.getResultText();
        Assertions.assertEquals(expected,actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/bootstrap-modal-demo.html#
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet.
    A tesztesetben ellenőrizd a modal alert ablak szöveges tartalmát összahasonlítva egy általad definiált elvárt eredménnyel.
    Nyisd meg a Single Modal ablakot, tárolt el az ablakon megjelenő szöveget egy változóba és zárd be az ablakot a bezárás gombbal
     */
    @Test
    @DisplayName("TC3")
    public void AlertTest()
    {
        base.popupKiller();
        alert.navigate();
        alert.clickOnModal();
        String expected = "This is the place where the content for the modal dialog displays";
        String actual = alert.getModalText();
        alert.clickOnCloseButton();
        Assertions.assertEquals(expected,actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/data-list-filter-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet.
    A teszteset ellenőrizze a névjegykártyák tartalmát.
    Olvasd ki a neveket a megjelenő névjegykártyákról és ellenőrzésként hasonlítsd össze egy elvárt eredményként megadott listával.
    Használj relatív útvonalat a névjegykártya név elemeinek kiolvasásához.
     */
    @Test
    @DisplayName("TC4")
    public void NamecardTest()
    {
        base.popupKiller();
        nameCard.navigate();
        List<String> actual = nameCard.getNames();
        List<String> expected = new ArrayList<>();
        expected.add("Tyreese Burn");
        expected.add("Brenda Tree");
        expected.add("Glenn Pho shizzle");
        expected.add("Brian Hoyies");
        expected.add("Glenn Pho shizzle");
        expected.add("Arman Cheyia");
        Assertions.assertEquals(expected,actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/table-data-download-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet.
    A tesztesetet ellenőrizze a táblázatból a neveket, amelyeket a táblázat első oszlop tartalmaz.
    Gyűjtsd össze a neveket és tárold le a names.txt fájlba majd a tesztesetben a fájl tartalmát hasonlítsd össze egy elvárt eredménnyel.
     */
    @Test
    @DisplayName("TC5")
    public void TableTest() throws IOException {
        base.popupKiller();
        table.navigate();
        table.writeNamesToFile();
        int expected = 32;
        int actual = table.lineCounter("names.txt");
        Assertions.assertEquals(expected,actual);
    }

}
