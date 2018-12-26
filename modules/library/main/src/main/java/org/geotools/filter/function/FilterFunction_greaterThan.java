package org.geotools.filter.function;

/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2005-2008, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */

// this code is autogenerated - you shouldnt be modifying it!

import static org.geotools.filter.capability.FunctionNameImpl.parameter;

import org.geotools.filter.FunctionExpressionImpl;
import org.geotools.filter.capability.FunctionNameImpl;
import org.opengis.filter.capability.FunctionName;

public class FilterFunction_greaterThan extends FunctionExpressionImpl {

    public static FunctionName NAME =
            new FunctionNameImpl(
                    "greaterThan",
                    parameter(
                            "greaterThan",
                            Boolean.class,
                            "greaterThan",
                            "Returns true if x > y. Parameters can be either numbers or strings (in the second case lexicographic ordering is used)"),
                    parameter(
                            "x",
                            Object.class,
                            "x",
                            "Can be any object type: date, string, number, etc..."),
                    parameter(
                            "y",
                            Object.class,
                            "y",
                            "Can be any object type: date, string, number, etc..."));

    public FilterFunction_greaterThan() {
        super(NAME);
    }

    public Object evaluate(Object feature) {
        Object arg0;
        Object arg1;

        try { // attempt to get value and perform conversion
            arg0 = (Object) getExpression(0).evaluate(feature);
        } catch (Exception e) // probably a type error
        {
            throw new IllegalArgumentException(
                    "Filter Function problem for function greaterThan argument #0 - expected type Object");
        }

        try { // attempt to get value and perform conversion
            arg1 = (Object) getExpression(1).evaluate(feature);
        } catch (Exception e) // probably a type error
        {
            throw new IllegalArgumentException(
                    "Filter Function problem for function greaterThan argument #1 - expected type Object");
        }

        return StaticGeometry.greaterThan(arg0, arg1);
    }
}
