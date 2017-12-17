/*
 * Copyright 2017 andrej.
 *
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
 */
package org.lorislab.clingo4j.api.ast;

import java.util.Optional;
import org.lorislab.clingo4j.api.Location;

/**
 *
 * @author andrej
 */
public class CSPProduct {

    private Location location;
    private Term coefficient;
    private Optional<Term> variable;

    public Term getCoefficient() {
        return coefficient;
    }

    public Location getLocation() {
        return location;
    }

    public Optional<Term> getVariable() {
        return variable;
    }

    @Override
    public String toString() {
        if (variable.isPresent()) {
            return "" + coefficient + "$*$" + variable.get();
        }
        return "" + coefficient;
    }

}
