// This is a generated file. Not intended for manual editing.
package com.albertoventurini.graphdbplugin.language.cypher.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.albertoventurini.graphdbplugin.language.cypher.references.types.CypherPathYielding;

public interface CypherRelationshipsPattern extends CypherPathYielding {

  @NotNull
  CypherNodePattern getNodePattern();

  @NotNull
  List<CypherPatternElementChain> getPatternElementChainList();

}