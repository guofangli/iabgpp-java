package com.iab.gpp.extras.jackson.gvl;

/*-
 * #%L
 * IAB TCF Java GVL Jackson
 * %%
 * Copyright (C) 2020 IAB Technology Laboratory, Inc
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.iab.gpp.extras.gvl.SpecialFeature;
import com.iab.gpp.extras.jackson.Loader;
import com.iab.gpp.extras.jackson.TestUtil;

public class SpecialFeatureTest {

    private static SpecialFeature specialFeatureOne;
    private final static int SPECIAL_FEAUTRE_ID_SELECTED_FOR_TEST = 1;

    @BeforeAll
    public static void setUp() throws Exception {
        Loader loader = new Loader();
        List<SpecialFeature> specialFeatures = loader.globalVendorList(TestUtil.getGlobalVendorList()).getSpecialFeatures();
        specialFeatureOne =
                specialFeatures.stream()
                    .filter(o -> o.getId() == SPECIAL_FEAUTRE_ID_SELECTED_FOR_TEST)
                    .findFirst()
                    .orElse(null);
    }

    @Test
    public void testGetId() {
        Assertions.assertEquals(1, specialFeatureOne.getId());
    }

    @Test
    public void testGetName() {
        String expectedName = "Use precise geolocation data";
        Assertions.assertEquals(expectedName, specialFeatureOne.getName());
    }

    @Test
    public void testGetDescription() {
        String expectedDescription =
                "Your precise geolocation data can be used in support of one or more purposes. This means your location can be accurate to within several meters.";
        Assertions.assertEquals(expectedDescription, specialFeatureOne.getDescription());
    }

    @Test
    public void testGetDescriptionLegal() {
        String expectedDescriptionLegal =
                "Vendors can:\n* Collect and process precise geolocation data in support of one or more purposes.\nN.B. Precise geolocation means that there are no restrictions on the precision of a user’s location; this can be accurate to within several meters.";
        Assertions.assertEquals(expectedDescriptionLegal, specialFeatureOne.getDescriptionLegal());
    }
}
