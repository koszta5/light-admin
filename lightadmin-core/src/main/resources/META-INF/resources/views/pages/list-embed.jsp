<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@ taglib prefix="light-jsp" uri="http://www.lightadmin.org/jsp" %>
<%@ taglib prefix="light" uri="http://www.lightadmin.org/tags" %>

<tiles:useAttribute name="fields"/>
<tiles:useAttribute name="scopes"/>
<tiles:useAttribute name="filters"/>

<tiles:useAttribute name="persistentEntity"/>
<tiles:useAttribute name="domainTypeAdministrationConfiguration"/>

<tiles:useAttribute name="entitySingularName"/>
<tiles:useAttribute name="entityPluralName"/>


<script type="text/javascript">
    var SEARCHER = createSearcher('${domainTypeAdministrationConfiguration.pluralDomainTypeName}');
</script>

<light-jsp:search filters="${filters}"/>

<light-jsp:data-table domainTypeAdministrationConfiguration="${domainTypeAdministrationConfiguration}"
                      fields="${fields}" scopes="${scopes}"/>