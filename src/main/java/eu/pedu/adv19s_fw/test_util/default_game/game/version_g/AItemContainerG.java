/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv19s_fw.test_util.default_game.game.version_g;

import eu.pedu.adv19s_fw.game_gui.IItemContainerG;
import eu.pedu.adv19s_fw.game_txt.INamed;
import eu.pedu.adv19s_fw.test_util.default_game.game.IMyItemContainer;
import eu.pedu.adv19s_fw.test_util.default_game.game.common.ANamed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;



/*******************************************************************************
 * Instances of the abstract class {@code AItemContainer} are
 * parent sub-objects of the objects performing as item containers.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2018-Winter
 */
abstract  class AItemContainerG
        extends ANamed
     implements IItemContainerG, IMyItemContainer<ItemG>
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============
//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Names of items in this container at the game beginning. */
    private final String[] itemNames;

    /** Names of items currently present in this container. */
    private final Collection<ItemG> items;

    /** Immutable collection of items currently present in this container,
     *  that continuously maps the {@link #items} collection content. */
    private final Collection<ItemG> exportedItems;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Creates the parent sub-object of the container of items
     * with the given names of its initial items.
     *
     * @param name      Name of the child object
     * @param itemNames Names of items in the container at the game beginning
     */
    AItemContainerG(String name, String... itemNames)
    {
        super(name);
        this.itemNames     = itemNames;
        this.items         = new ArrayList<>();
        this.exportedItems = Collections.unmodifiableCollection(items);
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Returns the item with the given name wrapped into
     * an {@link Optional}{@code <}{@link ItemG}{@code >}.
     *
     * @return The item with the given name wrapped into
     *         an {@link Optional}{@code <}{@link ItemG}{@code >}
     */
    @Override
    public Optional<ItemG> getOItem(String name)
    {
        return INamed.getO(name, items);
    }


    /***************************************************************************
     * Returns a collection of items located in the given container.
     *
     * @return Collection of items located in the given container
     */
    @Override
    public Collection<ItemG> getItems()
    {
        return exportedItems;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Adds the given item into the container.
     *
     * @param item The item that has to be added into the container
     */
    @Override
    public void addItem(ItemG item)
    {
        items.add(item);
    }


    /***************************************************************************
     * Cleans the container and saves into it the items
     * located in the given container at the game beginning.
     */
    @Override
    public void initializeItems()
    {
        items.clear();
        Arrays.stream(itemNames)
              .map(ItemG::new)
              .forEach(items::add);
    }


    /***************************************************************************
     * Removes the given item from this container.
     *
     * @param item ItemG to be removed
     */
    @Override
    public void removeItem(ItemG item)
    {
        items.remove(item);
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
