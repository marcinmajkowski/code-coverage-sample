// ============================================================================
//  File          : PetOwnerSteps
//  Created       : 05.04.2012   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package com.xpinjection.coverage.steps;

import com.xpinjection.coverage.pages.MainPage;
import com.xpinjection.coverage.pages.PetOwnersPage;
import com.xpinjection.coverage.pages.PetOwnersSearchPage;
import com.xpinjection.coverage.pages.VeterinariansPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.matchers.BeanMatcher;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class PetOwnerSteps extends ScenarioSteps {
    public PetOwnerSteps(final Pages pages) {
        super(pages);
    }

    @Step
    public void openVeterinariansPage() {
        onMainPage().openVeterinariansPage();
    }

    @Step
    public void openPetOwnersSearchPage() {
        onMainPage().openPetOwnersSearchPage();
    }

    @Step
    public void searchPetOwnerByLastName(String lastName) {
        pages().currentPageAt(PetOwnersSearchPage.class)
                .searchForPetOwners(lastName);
    }

    @Step
    public void shouldBeListOfPredefinedVeterinarians(int expectedCount) {
        int existingCount = pages().currentPageAt(VeterinariansPage.class)
                .getAllExistingVeterinarians().size();
        assertEquals(expectedCount, existingCount);
    }

    @Step
    public void petOwnerWithFollowingDataShouldPresent(BeanMatcher... matchers) {
        assertTrue(pages().currentPageAt(PetOwnersPage.class).isPetOwnerFound(matchers));
    }

    private MainPage onMainPage() {
        MainPage mainPage = pages().get(MainPage.class);
        mainPage.open();
        return mainPage;
    }
}
