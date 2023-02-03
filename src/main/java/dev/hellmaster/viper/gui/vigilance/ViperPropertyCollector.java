package dev.hellmaster.viper.gui.vigilance;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyCollector;
import gg.essential.vigilance.data.PropertyData;
import gg.essential.vigilance.data.PropertyType;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ViperPropertyCollector extends PropertyCollector {
    @NotNull
    @Override
    protected List<PropertyData> collectProperties(@NotNull Vigilant instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Field[] var10000 = instance.getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(var10000, "instance::class.java.declaredFields");
        Object[] thisfilter = var10000;
        Collection destination = new ArrayList();
        Field[] var8 = (Field[]) thisfilter;
        int var9 = thisfilter.length;

        int var10;
        for(var10 = 0; var10 < var9; ++var10) {
            AccessibleObject element = var8[var10];
            if (element.isAnnotationPresent(Property.class)) {
                destination.add(element);
            }
        }

        Iterable thismap = destination;
        destination = (new ArrayList(collectionSizeOrDefault(thismap, 10)));
        Iterator var25 = thismap.iterator();

        Property var10001;
        PropertyData.Companion var38;
        while(var25.hasNext()) {
            Object item = var25.next();
            Field field = (Field)item;
            Intrinsics.checkNotNullExpressionValue(field, "field");
            field.setAccessible(true);
            var38 = PropertyData.Companion;
            var10001 = field.getAnnotation(Property.class);
            Intrinsics.checkNotNullExpressionValue(var10001, "field.getAnnotation(Property::class.java)");
            PropertyData var12 = var38.fromField(var10001, field, instance);
            if (!var12.getAttributesExt().getType().isFieldValid(field)) {
                StringBuilder var10002 = (new StringBuilder()).append("[Vigilance] Error while creating GUI ").append(Reflection.getOrCreateKotlinClass(instance.getClass()).getSimpleName()).append(": ").append("field ").append(field.getName()).append(" of PropertyType ").append(var12.getAttributesExt().getType().name()).append(" has invalid JVM type ");
                Class<?> var10003 = field.getType();
                Intrinsics.checkNotNullExpressionValue(var10003, "field.type");
                try {
                    throw new IllegalStateException(var10002.append(var10003.getSimpleName()).toString());
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }

            destination.add(var12);
        }

        List fieldPropertyData = (List)destination;
        Method[] var39 = instance.getClass().getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(var39, "instance::class.java.declaredMethods");
        thisfilter = var39;
        destination = (new ArrayList());
        Method[] var28 = (Method[]) thisfilter;
        var10 = thisfilter.length;

        for(int var33 = 0; var33 < var10; ++var33) {
            AccessibleObject element = var28[var33];
            if (element.isAnnotationPresent(Property.class)) {
                destination.add(element);
            }
        }

        thismap = destination;
        destination = (new ArrayList(collectionSizeOrDefault(thismap, 10)));

        for (Object item : thismap) {
            Method method = (Method) item;
            Intrinsics.checkNotNullExpressionValue(method, "method");
            method.setAccessible(true);
            var38 = PropertyData.Companion;
            var10001 = method.getAnnotation(Property.class);
            Intrinsics.checkNotNullExpressionValue(var10001, "method.getAnnotation(Property::class.java)");
            PropertyData var37 = var38.fromMethod(var10001, method, instance);
            if (var37.getAttributesExt().getType() != PropertyType.BUTTON) {
                try {
                    throw new IllegalStateException("[Vigilance] Error while creating GUI " + Reflection.getOrCreateKotlinClass(instance.getClass()).getSimpleName() + ": " + "expected method " + method.getName() + " to have PropertyType BUTTON, but found PropertyType " + var37.getAttributesExt().getType().name());
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }

            destination.add(var37);
        }

        List methodPropertyData = (List)destination;
        return CollectionsKt.plus(fieldPropertyData, methodPropertyData);
    }

    public final int collectionSizeOrDefault(@NotNull Iterable collectionSizeOrDefault, int var2) {
        Intrinsics.checkNotNullParameter(collectionSizeOrDefault, "collectionSizeOrDefault");
        return collectionSizeOrDefault instanceof Collection ? ((Collection<?>)collectionSizeOrDefault).size() : var2;
    }
}