/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv19s_fw.test_util.game_txt_test;

import eu.pedu.adv19s_fw.game_txt.IGSMFactory;
import eu.pedu.adv19s_fw.scenario.AScenarioManager;



/*******************************************************************************
 * Instance třídy {@code BasicSetTester} představují testery prověřující
 * základní řešení výchozího zadání bez jakýchkoliv dodatečných modifikací.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2018-Winter
 */
public class GivenSetTester extends ASolutionTester
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    public static final String DESCRIPTION =
      "Základní řešení výchozího zadání bez dodatečných modifikací";



//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================




//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří tester prověřující řešení základního zadání.
     *
     * @param names Názvy testovacích scénářů
     */
    public GivenSetTester(String... names)
    {
        super("19s", DESCRIPTION, Visitor::new, names);
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================

    /***************************************************************************
     * Instance třídy {@code Visitor} představují návštěvníky prověřující
     * splnění základního zadání semestrální práce.
     */
    private static class Visitor extends ATestVisitor
    {
    //== CONSTUCTORS AND FACTORY METHODS =======================================

        /***********************************************************************
         * Vytvoří návštěvníka pro prověření základní funkčnosti hry
         * poskytnuté zadaným továrním objektem.
         *
         * @param myTest  Zadavatel požadující vyřešení základního zadání
         * @param factory Tovární objekt poskytující základní objekty
         *                prověřované aplikace
         */
        Visitor(ASolutionTester myTest, IGSMFactory factory)
        {
            super(myTest, factory);
        }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

        /***************************************************************************
         * Vrátí sdružený tester, jehož zadání prověřuje.
         *
         * @return Sdružený tester
         */
        @Override
        public ASolutionTester getTester()
        {
            return myTest;
        }

    }

}
