//
// File: ImakeMacro.java
//
// UK Crown Copyright (c) 2008. All Rights Reserved.
//
package org.xtuml.masl.translate.cmake;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;

import org.xtuml.masl.translate.build.FileGroup;
import org.xtuml.masl.translate.build.ReferencedFile;
import org.xtuml.masl.translate.cmake.functions.SimpleAddInterfaceLibrary;


public class BuildInterfaceLibrary
    implements CMakeListsItem
{

  public BuildInterfaceLibrary ( final FileGroup library, final File sourcePath )
  {
    addLib = new SimpleAddInterfaceLibrary(Utils.getNameArg(library),
                                           Utils.getPathArgs(Collections.<ReferencedFile>emptyList()),
                                           Utils.getNameArgs(library.getDependencies()),
                                           null,
                                           false,
                                           Utils.getPathArgs(Collections.<ReferencedFile>emptyList()));
  }

  @Override
  public void writeCode ( final Writer writer, final String indent ) throws IOException
  {
    addLib.writeCode(writer, "");
  }

  private final SimpleAddInterfaceLibrary addLib;

}
