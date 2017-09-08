/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.economy.intranet.core.jsonhelper;


import ge.economy.intranet.core.formaters.BaseDateFormatter;

/**
 * @author nino
 */
public class JsonDateDeSerializeSupport extends AbstractDateDeSerializeSupport {

    @Override
    String getDateFormat() {
        return BaseDateFormatter.DATE_FORMAT;
    }
}
