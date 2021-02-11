/**
 * @(#)VideoFilter.java 1.0 09/03/22
 *
 * Copyright (2003) Ron Knutson
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2, or any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place, Boston, MA 02111.
 *
 *
 **/

package xcx;

import java.io.*;
import javax.swing.filechooser.FileFilter;

public class ImageFilter extends FileFilter {

        public boolean accept(File f) {

            if (f.isDirectory()) {
                return true;
            }

            String fname = f.getName();
            int fnameLength = fname.length();
            if (fnameLength < 5) {
                return false;
            }

            if (fname.toLowerCase().endsWith(".jpg")) {

                return true;
            }
            return false;
        } // accept

        /**
         * Returns the description of this file filter.
         *
         * @return  String description of this filter.
         */
        public String getDescription() {
            return "Archivos gráficos; jpg";
        }
  }
