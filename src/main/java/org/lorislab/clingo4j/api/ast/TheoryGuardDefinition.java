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

import java.util.List;
import java.util.Optional;
import org.bridj.Pointer;
import org.lorislab.clingo4j.api.c.clingo_ast_theory_guard_definition;
import org.lorislab.clingo4j.util.ClingoUtil;
import org.lorislab.clingo4j.util.StringList;

/**
 *
 * @author andrej
 */
public class TheoryGuardDefinition {

    private final String term;
    private final List<String> operators;

    public TheoryGuardDefinition(clingo_ast_theory_guard_definition d) {
        this(d.term().getCString(), new StringList(d.operators(), d.size()));
    }
    
    public TheoryGuardDefinition(String term, List<String> operators) {
        this.term = term;
        this.operators = operators;
    }

    public List<String> getOperators() {
        return operators;
    }

    public String getTerm() {
        return term;
    }

    @Override
    public String toString() {
        return "{ " + ClingoUtil.print(operators, "", ", ", "", false) + " }, " + term;
    }

    public static Optional<TheoryGuardDefinition> convert(Pointer<clingo_ast_theory_guard_definition> p) {
        if (p != null && p.get() != null) {
            return Optional.of(new TheoryGuardDefinition(p.get()));
        }
        return Optional.empty();
    }

}
