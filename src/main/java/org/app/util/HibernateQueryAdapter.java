package org.app.util;


import org.app.entity.marke.EntityIdentity;

import java.util.Date;
import java.util.Map;
import java.util.Set;


/**
 * @author ÁõÏéµÂ qq313700046@icloud.com .
 * @date Created in ${Time} ${Date}.
 * @decreption
 * @modified By: .
 */

public class HibernateQueryAdapter
{

    private static int currentPlaceholder;

    public static String getHqlConditionFragmentStringByMapping(Map<String, Object> mapping,
                                                                StringBuilder fragmentBuilder)
    {
        Set<String> propertySet = mapping.keySet();
        for (String key : propertySet)
        {
            Object value = mapping.get(key);
            propertyTypeResolveAndBuild(key, value, fragmentBuilder, 1);
        }
        currentPlaceholder = 0;
        return fragmentBuilder.toString();
    }

    public static String getHqlUpdateFragmentStringByMapping(Map<String, Object> mapping,
                                                             StringBuilder fragmentBuilder)
    {
        Set<String> propertySet = mapping.keySet();
        boolean isFirstProperty = true;
        for (String key : propertySet)
        {
            Object value = mapping.get(key);
            if (isFirstProperty)
            {
                propertyTypeResolveAndBuild(key, value, fragmentBuilder, 0);
                isFirstProperty = false;
            }
            else
            {
                propertyTypeResolveAndBuild(key, value, fragmentBuilder, 0).insert(0,",");
            }
        }
        currentPlaceholder = 0;
        return fragmentBuilder.toString();
    }

    private static String setHqlFragmentPlaceholders(String key, int placeholder)
    {
        return key + " = ?" + placeholder;
    }

    private static StringBuilder propertyTypeResolveAndBuild(String key, Object value,
                                                             StringBuilder fragmentBuilder,
                                                             int resolveType)
    {
        if (resolveType == 1)
        {
            if (value instanceof String)
            {
                fragmentBuilder.append(" and ").append(key).append("='").append(value).append("'");
            }
            else if (value instanceof EntityIdentity)
            {
                fragmentBuilder.append(" and ").append(
                    setHqlFragmentPlaceholders(key, currentPlaceholder));
                ++currentPlaceholder;
            }
            else
            {
                fragmentBuilder.append(" and ").append(key).append(" = ").append(value);
            }

        }
        else
        {
            if (value instanceof String)
            {
                fragmentBuilder.append(key).append("='").append(value).append("'");
            }
            else if (value instanceof EntityIdentity)
            {
                fragmentBuilder.append(setHqlFragmentPlaceholders(key, currentPlaceholder));
                ++currentPlaceholder;
            }
            else
            {
                fragmentBuilder.append(key).append(" = ").append(value);
            }

        }
        return fragmentBuilder;
    }
}
