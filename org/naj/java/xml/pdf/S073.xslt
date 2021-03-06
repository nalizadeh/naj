<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:fo="http://www.w3.org/1999/XSL/Format" version="1.0">
  <xsl:variable name="filename">XSD2PDF_S073_EN_4.2.0_4.0.1.xslt</xsl:variable>
  <xsl:variable name="version">4.2.0_4.0.1</xsl:variable>
  <xsl:output method="xml" encoding="UTF-8"/>
  <xsl:template match="/">
    <fo:root font-family="Arial Unicode MS" font-size="10pt">
      <fo:layout-master-set>
        <fo:simple-page-master master-name="Standard" page-height="29.7cm" page-width="21cm" margin-top="1cm" margin-bottom="2cm" margin-left="1.25cm" margin-right="1.25cm">
          <fo:region-body margin-top="3.5cm" margin-left="1.0cm"/>
          <fo:region-before extent="2.5cm" margin-left="1.5cm"/>
          <fo:region-after extent="1.5cm" margin-left="1.5cm"/>
          <fo:region-start region-name="vertikal" extent="0.5cm" reference-orientation="90"/>
        </fo:simple-page-master>
      </fo:layout-master-set>
      <fo:page-sequence master-reference="Standard">
        <fo:static-content flow-name="xsl-region-before">
          <fo:table table-layout="fixed" width="100%" margin="5mm 0mm 0mm 0mm">
            <fo:table-column column-width="70%"/>
            <fo:table-column column-width="30%"/>
            <fo:table-body>
              <fo:table-row>
                <fo:table-cell>
                  <fo:block font-family="Arial Unicode MS" margin-left="5mm" font-size="14pt" text-align="start">S073 - Information of registration - residence</fo:block>
                  <fo:block font-family="Arial Unicode MS" margin-left="5mm" font-size="8pt" text-align="start">S073 - Information of registration - residence</fo:block>
                </fo:table-cell>
                <fo:table-cell>
                  <fo:block text-align="right" font-weight="bold">EESSI data record</fo:block>
                  <fo:block text-align="right" font-weight="bold">Copy identical to original</fo:block>
                </fo:table-cell>
              </fo:table-row>
            </fo:table-body>
          </fo:table>
        </fo:static-content>
        <fo:static-content flow-name="xsl-region-after">
          <fo:block font-family="Arial Unicode MS" font-size="8pt" margin-top="50pt" margin-left="15pt">
            <fo:block>[Page 
              <fo:page-number/> /
              <fo:page-number-citation ref-id="endofflow"/>] [Case-ID: 
              <xsl:value-of select="//*[local-name() = 'StandardBusinessDocumentHeader']/*[local-name() = 'BusinessScope']/*[local-name() = 'CaseId']/*[local-name() = 'InstanceIdentifier']"/>] [Original SED from 
              <xsl:value-of select="//*[local-name() = 'StandardBusinessDocumentHeader']/*[local-name() = 'DocumentIdentification']/*[local-name() = 'CreationDateAndTime']"/>]
            </fo:block>
            <fo:block>[Sender:
              <xsl:value-of select="//*[local-name() = 'StandardBusinessDocumentHeader']/*[local-name() = 'Sender']/*[local-name() = 'Identifier']"/> (
              <xsl:value-of select="//*[local-name() = 'StandardBusinessDocumentHeader']/*[local-name() = 'Sender']/*[local-name() = 'ContactTypeIdentifier']"/>)] [Recipient: 
              <xsl:value-of select="//*[local-name() = 'StandardBusinessDocumentHeader']/*[local-name() = 'Receiver']/*[local-name() = 'Identifier']"/> (
              <xsl:value-of select="//*[local-name() = 'StandardBusinessDocumentHeader']/*[local-name() = 'Receiver']/*[local-name() = 'ContactTypeIdentifier']"/>)]
            </fo:block>
          </fo:block>
        </fo:static-content>
        <fo:static-content flow-name="vertikal">
          <fo:block padding-before="4pt" font-size="8pt">PDF generiert durch 
            <xsl:value-of select="$filename"/> - v.
            <xsl:value-of select="$version"/> © 2020, DVKA, Bonn.
          </fo:block>
        </fo:static-content>
        <fo:flow flow-name="xsl-region-body">
          <fo:block font-family="Arial Unicode MS" font-size="10pt">Articles 17, 22, 24, 25, 26 of Regulation (EC) No 883/2004; Article 24 of Regulation (EC) No 987/2009</fo:block>
          <fo:block>
            <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
              <fo:table-column column-width="45%"/>
              <fo:table-column column-width="53%"/>
              <fo:table-header background-color="LightGrey">
                <fo:table-row border="solid 0.2mm Grey">
                  <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm" font-weight="bold">
                    <fo:block>1. Person</fo:block>
                  </fo:table-cell>
                </fo:table-row>
              </fo:table-header>
              <fo:table-body>
                <fo:table-row>
                  <fo:table-cell number-columns-spanned="2">
                    <fo:block>
                      <fo:block>
                        <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                          <fo:table-column column-width="45%"/>
                          <fo:table-column column-width="53%"/>
                          <fo:table-header background-color="LightGrey">
                            <fo:table-row border="solid 0.2mm Grey">
                              <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                <fo:block>1.1. Person Identification</fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                          </fo:table-header>
                          <fo:table-body>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>1.1.1. Family name(s)</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//Person/PersonIdentification/familyName"/>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>1.1.2. Forename(s)</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//Person/PersonIdentification/forename"/>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>1.1.3. Date of birth</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//Person/PersonIdentification/dateBirth"/>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>1.1.4. Sex</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//Person/PersonIdentification/sex"/>  
                                  <fo:block>
                                    <xsl:choose>
                                      <xsl:when test="//Person/PersonIdentification/sex/value='01'">
                                        <fo:block>Male</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//Person/PersonIdentification/sex/value='02'">
                                        <fo:block>Female</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//Person/PersonIdentification/sex/value='98'">
                                        <fo:block>Unknown</fo:block>
                                      </xsl:when>
                                      <xsl:otherwise>
                                        <fo:block>-/-</fo:block>
                                      </xsl:otherwise>
                                    </xsl:choose>
                                  </fo:block>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>1.1.5. Family name(s) at birth</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//Person/PersonIdentification/familyNameAtBirth"/>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>1.1.6. Forename(s) at birth</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//Person/PersonIdentification/forenameAtBirth"/>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell number-columns-spanned="2">
                                <fo:block>
                                  <fo:block>
                                    <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                      <fo:table-column column-width="45%"/>
                                      <fo:table-column column-width="53%"/>
                                      <fo:table-header background-color="LightGrey">
                                        <fo:table-row border="solid 0.2mm Grey">
                                          <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>1.1.7. PIN of the person in each institution</fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                      </fo:table-header>
                                      <fo:table-body>
                                        <xsl:for-each select="//Person/PersonIdentification/PINPersonInEachInstitution/PersonalIdentificationNumber">
                                          <fo:table-row>
                                            <fo:table-cell number-columns-spanned="2">
                                              <fo:block>
                                                <fo:block>
                                                  <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                                    <fo:table-column column-width="45%"/>
                                                    <fo:table-column column-width="53%"/>
                                                    <fo:table-header background-color="LightGrey">
                                                      <fo:table-row border="solid 0.2mm Grey">
                                                        <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                                          <fo:block>1.1.7.1.[
                                                            <xsl:value-of select="position()"/>] Personal Identification Number(s)
                                                          </fo:block>
                                                        </fo:table-cell>
                                                      </fo:table-row>
                                                    </fo:table-header>
                                                    <fo:table-body>
                                                      <fo:table-row>
                                                        <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                          <fo:block>1.1.7.1.1.[
                                                            <xsl:value-of select="position()"/>] Country
                                                          </fo:block>
                                                        </fo:table-cell>
                                                        <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                          <fo:block>
                                                            <xsl:value-of select="country"/>  
                                                            <fo:block>
                                                              <xsl:choose>
                                                                <xsl:when test="country/value='DE'">
                                                                  <fo:block>Germany</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='NO'">
                                                                  <fo:block>Norway</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='BE'">
                                                                  <fo:block>Belgium</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='FI'">
                                                                  <fo:block>Finland</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='PT'">
                                                                  <fo:block>Portugal</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='BG'">
                                                                  <fo:block>Bulgaria</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='DK'">
                                                                  <fo:block>Denmark</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='LT'">
                                                                  <fo:block>Lithuania</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='LU'">
                                                                  <fo:block>Luxembourg</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='HR'">
                                                                  <fo:block>Croatia</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='LV'">
                                                                  <fo:block>Latvia</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='FR'">
                                                                  <fo:block>France</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='HU'">
                                                                  <fo:block>Hungary</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='SE'">
                                                                  <fo:block>Sweden</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='SI'">
                                                                  <fo:block>Slovenia</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='UK'">
                                                                  <fo:block>United Kingdom</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='SK'">
                                                                  <fo:block>Slovakia</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='IE'">
                                                                  <fo:block>Ireland</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='EE'">
                                                                  <fo:block>Estonia</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='CH'">
                                                                  <fo:block>Switzerland</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='EL'">
                                                                  <fo:block>Greece</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='MT'">
                                                                  <fo:block>Malta</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='IS'">
                                                                  <fo:block>Iceland</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='IT'">
                                                                  <fo:block>Italy</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='ES'">
                                                                  <fo:block>Spain</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='AT'">
                                                                  <fo:block>Austria</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='CY'">
                                                                  <fo:block>Cyprus</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='CZ'">
                                                                  <fo:block>Czechia</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='PL'">
                                                                  <fo:block>Poland</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='LI'">
                                                                  <fo:block>Liechtenstein</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='RO'">
                                                                  <fo:block>Romania</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="country/value='NL'">
                                                                  <fo:block>Netherlands</fo:block>
                                                                </xsl:when>
                                                                <xsl:otherwise>
                                                                  <fo:block>-/-</fo:block>
                                                                </xsl:otherwise>
                                                              </xsl:choose>
                                                            </fo:block>
                                                          </fo:block>
                                                        </fo:table-cell>
                                                      </fo:table-row>
                                                      <fo:table-row>
                                                        <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                          <fo:block>1.1.7.1.2.[
                                                            <xsl:value-of select="position()"/>] Personal Identification Number (PIN)
                                                          </fo:block>
                                                        </fo:table-cell>
                                                        <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                          <fo:block>
                                                            <xsl:value-of select="personalIdentificationNumber"/>
                                                          </fo:block>
                                                        </fo:table-cell>
                                                      </fo:table-row>
                                                      <fo:table-row>
                                                        <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                          <fo:block>1.1.7.1.3.[
                                                            <xsl:value-of select="position()"/>] Sector
                                                          </fo:block>
                                                        </fo:table-cell>
                                                        <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                          <fo:block>
                                                            <xsl:value-of select="sector"/>  
                                                            <fo:block>
                                                              <xsl:choose>
                                                                <xsl:when test="sector/value='01'">
                                                                  <fo:block>AWOD</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="sector/value='02'">
                                                                  <fo:block>Family Benefits</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="sector/value='03'">
                                                                  <fo:block>All</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="sector/value='04'">
                                                                  <fo:block>Pensions</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="sector/value='05'">
                                                                  <fo:block>Recovery</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="sector/value='06'">
                                                                  <fo:block>Sickness</fo:block>
                                                                </xsl:when>
                                                                <xsl:when test="sector/value='07'">
                                                                  <fo:block>Unemployment Benefits</fo:block>
                                                                </xsl:when>
                                                                <xsl:otherwise>
                                                                  <fo:block>-/-</fo:block>
                                                                </xsl:otherwise>
                                                              </xsl:choose>
                                                            </fo:block>
                                                          </fo:block>
                                                        </fo:table-cell>
                                                      </fo:table-row>
                                                      <fo:table-row>
                                                        <fo:table-cell number-columns-spanned="2">
                                                          <fo:block>
                                                            <fo:block>
                                                              <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                                                <fo:table-column column-width="45%"/>
                                                                <fo:table-column column-width="53%"/>
                                                                <fo:table-header background-color="LightGrey">
                                                                  <fo:table-row border="solid 0.2mm Grey">
                                                                    <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                                                      <fo:block>1.1.7.1.4.[
                                                                        <xsl:value-of select="position()"/>] Institution
                                                                      </fo:block>
                                                                    </fo:table-cell>
                                                                  </fo:table-row>
                                                                </fo:table-header>
                                                                <fo:table-body>
                                                                  <fo:table-row>
                                                                    <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                      <fo:block>1.1.7.1.4.1.[
                                                                        <xsl:value-of select="position()"/>] Institution ID
                                                                      </fo:block>
                                                                    </fo:table-cell>
                                                                    <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                      <fo:block>
                                                                        <xsl:value-of select="Institution/institutionID"/>
                                                                      </fo:block>
                                                                    </fo:table-cell>
                                                                  </fo:table-row>
                                                                  <fo:table-row>
                                                                    <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                      <fo:block>1.1.7.1.4.2.[
                                                                        <xsl:value-of select="position()"/>] Institution Name
                                                                      </fo:block>
                                                                    </fo:table-cell>
                                                                    <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                      <fo:block>
                                                                        <xsl:value-of select="Institution/institutionName"/>
                                                                      </fo:block>
                                                                    </fo:table-cell>
                                                                  </fo:table-row>
                                                                </fo:table-body>
                                                              </fo:table>
                                                            </fo:block>
                                                          </fo:block>
                                                        </fo:table-cell>
                                                      </fo:table-row>
                                                    </fo:table-body>
                                                  </fo:table>
                                                </fo:block>
                                              </fo:block>
                                            </fo:table-cell>
                                          </fo:table-row>
                                        </xsl:for-each>
                                        <xsl:if test="not(//Person/PersonIdentification/PINPersonInEachInstitution/PersonalIdentificationNumber)">
                                          <fo:table-row>
                                            <fo:table-cell number-columns-spanned="2">
                                              <fo:block/>
                                            </fo:table-cell>
                                          </fo:table-row>
                                        </xsl:if>
                                      </fo:table-body>
                                    </fo:table>
                                  </fo:block>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell number-columns-spanned="2">
                                <fo:block>
                                  <fo:block>
                                    <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                      <fo:table-column column-width="45%"/>
                                      <fo:table-column column-width="53%"/>
                                      <fo:table-header background-color="LightGrey">
                                        <fo:table-row border="solid 0.2mm Grey">
                                          <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>1.1.8. If PIN not provided for every institution, please provide</fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                      </fo:table-header>
                                      <fo:table-body>
                                        <fo:table-row>
                                          <fo:table-cell number-columns-spanned="2">
                                            <fo:block>
                                              <fo:block>
                                                <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                                  <fo:table-column column-width="45%"/>
                                                  <fo:table-column column-width="53%"/>
                                                  <fo:table-header background-color="LightGrey">
                                                    <fo:table-row border="solid 0.2mm Grey">
                                                      <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>1.1.8.1. Place of birth</fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                  </fo:table-header>
                                                  <fo:table-body>
                                                    <fo:table-row>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>1.1.8.1.1. Town</fo:block>
                                                      </fo:table-cell>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>
                                                          <xsl:value-of select="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/town"/>
                                                        </fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                    <fo:table-row>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>1.1.8.1.2. Region</fo:block>
                                                      </fo:table-cell>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>
                                                          <xsl:value-of select="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/region"/>
                                                        </fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                    <fo:table-row>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>1.1.8.1.3. Country</fo:block>
                                                      </fo:table-cell>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>
                                                          <xsl:value-of select="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country"/>  
                                                          <fo:block>
                                                            <xsl:choose>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PR'">
                                                                <fo:block>Puerto Rico</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PS'">
                                                                <fo:block>Palestine, State of</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PT'">
                                                                <fo:block>Portugal</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PW'">
                                                                <fo:block>Palau</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PY'">
                                                                <fo:block>Paraguay</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='QA'">
                                                                <fo:block>Qatar</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PCHH'">
                                                                <fo:block>Pacific Islands, Trust Territory of the</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AD'">
                                                                <fo:block>Andorra</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AE'">
                                                                <fo:block>United Arab Emirates</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AF'">
                                                                <fo:block>Afghanistan</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AG'">
                                                                <fo:block>Antigua and Barbuda</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AI'">
                                                                <fo:block>Anguilla</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AL'">
                                                                <fo:block>Albania</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AM'">
                                                                <fo:block>Armenia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AO'">
                                                                <fo:block>Angola</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AQ'">
                                                                <fo:block>Antarctica</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AR'">
                                                                <fo:block>Argentina</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AS'">
                                                                <fo:block>American Samoa</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AT'">
                                                                <fo:block>Austria</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='RE'">
                                                                <fo:block>Réunion</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AU'">
                                                                <fo:block>Australia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AW'">
                                                                <fo:block>Aruba</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AX'">
                                                                <fo:block>Aland Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AZ'">
                                                                <fo:block>Azerbaijan</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='RO'">
                                                                <fo:block>Romania</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BA'">
                                                                <fo:block>Bosnia and Herzegovina</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BB'">
                                                                <fo:block>Barbados</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='RS'">
                                                                <fo:block>Serbia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BD'">
                                                                <fo:block>Bangladesh</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BE'">
                                                                <fo:block>Belgium</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='RU'">
                                                                <fo:block>Russian Federation</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BF'">
                                                                <fo:block>Burkina Faso</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='WKUM'">
                                                                <fo:block>Wake Island</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BG'">
                                                                <fo:block>Bulgaria</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='RW'">
                                                                <fo:block>Rwanda</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BH'">
                                                                <fo:block>Bahrain</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BI'">
                                                                <fo:block>Burundi</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BJ'">
                                                                <fo:block>Benin</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BL'">
                                                                <fo:block>Saint Barthélemy</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BM'">
                                                                <fo:block>Bermuda</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BN'">
                                                                <fo:block>Brunei Darussalam</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BO'">
                                                                <fo:block>Bolivia, Plurinational State of</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SA'">
                                                                <fo:block>Saudi Arabia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BQ'">
                                                                <fo:block>Bonaire, Sint Eustatius and Saba</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SB'">
                                                                <fo:block>Solomon Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BR'">
                                                                <fo:block>Brazil</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SC'">
                                                                <fo:block>Seychelles</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BS'">
                                                                <fo:block>Bahamas</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SD'">
                                                                <fo:block>Sudan</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SE'">
                                                                <fo:block>Sweden</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BT'">
                                                                <fo:block>Bhutan</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BV'">
                                                                <fo:block>Bouvet Island</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SG'">
                                                                <fo:block>Singapore</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BW'">
                                                                <fo:block>Botswana</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SH'">
                                                                <fo:block>Saint Helena, Ascension and Tristan da Cunha</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SI'">
                                                                <fo:block>Slovenia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BY'">
                                                                <fo:block>Belarus</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SJ'">
                                                                <fo:block>Svalbard and Jan Mayen</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SK'">
                                                                <fo:block>Slovakia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BZ'">
                                                                <fo:block>Belize</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SL'">
                                                                <fo:block>Sierra Leone</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SM'">
                                                                <fo:block>San Marino</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SN'">
                                                                <fo:block>Senegal</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SO'">
                                                                <fo:block>Somalia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CA'">
                                                                <fo:block>Canada</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SR'">
                                                                <fo:block>Suriname</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CC'">
                                                                <fo:block>Cocos (Keeling) Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SS'">
                                                                <fo:block>South Sudan</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CD'">
                                                                <fo:block>Congo, the Democratic Republic of the</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ST'">
                                                                <fo:block>Sao Tome and Principe</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CF'">
                                                                <fo:block>Central African Republic</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SV'">
                                                                <fo:block>El Salvador</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CG'">
                                                                <fo:block>Congo</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CH'">
                                                                <fo:block>Switzerland</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SX'">
                                                                <fo:block>Sint Maarten (Dutch part)</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CI'">
                                                                <fo:block>Côte d'Ivoire</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SY'">
                                                                <fo:block>Syrian Arab Republic</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SZ'">
                                                                <fo:block>Swaziland</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CK'">
                                                                <fo:block>Cook Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CL'">
                                                                <fo:block>Chile</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CM'">
                                                                <fo:block>Cameroon</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CN'">
                                                                <fo:block>China</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CO'">
                                                                <fo:block>Colombia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CR'">
                                                                <fo:block>Costa Rica</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TC'">
                                                                <fo:block>Turks and Caicos Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TD'">
                                                                <fo:block>Chad</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CU'">
                                                                <fo:block>Cuba</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TF'">
                                                                <fo:block>French Southern Territories</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CV'">
                                                                <fo:block>Cape Verde</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TG'">
                                                                <fo:block>Togo</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CW'">
                                                                <fo:block>Curaçao</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TH'">
                                                                <fo:block>Thailand</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CX'">
                                                                <fo:block>Christmas Island</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CY'">
                                                                <fo:block>Cyprus</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TJ'">
                                                                <fo:block>Tajikistan</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CZ'">
                                                                <fo:block>Czech Republic</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TK'">
                                                                <fo:block>Tokelau</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TL'">
                                                                <fo:block>Timor-Leste</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TM'">
                                                                <fo:block>Turkmenistan</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TN'">
                                                                <fo:block>Tunisia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TO'">
                                                                <fo:block>Tonga</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TR'">
                                                                <fo:block>Turkey</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GEHH'">
                                                                <fo:block>Gilbert and Ellice Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TT'">
                                                                <fo:block>Trinidad and Tobago</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DE'">
                                                                <fo:block>Germany</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TV'">
                                                                <fo:block>Tuvalu</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TW'">
                                                                <fo:block>Taiwan, Province of China</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DJ'">
                                                                <fo:block>Djibouti</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TZ'">
                                                                <fo:block>Tanzania, United Republic of</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DK'">
                                                                <fo:block>Denmark</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DM'">
                                                                <fo:block>Dominica</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DO'">
                                                                <fo:block>Dominican Republic</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='UA'">
                                                                <fo:block>Ukraine</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='UG'">
                                                                <fo:block>Uganda</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='UK'">
                                                                <fo:block>United Kingdom</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DZ'">
                                                                <fo:block>Algeria</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='UM'">
                                                                <fo:block>United States Minor Outlying Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='EC'">
                                                                <fo:block>Ecuador</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='US'">
                                                                <fo:block>United States of America</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='EE'">
                                                                <fo:block>Estonia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BQAQ'">
                                                                <fo:block>British Antarctic Territory</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='EG'">
                                                                <fo:block>Egypt</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='EH'">
                                                                <fo:block>Western Sahara</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='UY'">
                                                                <fo:block>Uruguay</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='UZ'">
                                                                <fo:block>Uzbekistan</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='YUCS'">
                                                                <fo:block>Yugoslavia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='EL'">
                                                                <fo:block>Greece</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BYAA'">
                                                                <fo:block>Byelorussian SSR</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VA'">
                                                                <fo:block>Holy See</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ER'">
                                                                <fo:block>Eritrea</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VC'">
                                                                <fo:block>Saint Vincent and the Grenadines</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ES'">
                                                                <fo:block>Spain</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ET'">
                                                                <fo:block>Ethiopia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VE'">
                                                                <fo:block>Venezuela, Bolivarian Republic of</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AIDJ'">
                                                                <fo:block>French Afar and Issas</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VG'">
                                                                <fo:block>Virgin Islands, British</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VI'">
                                                                <fo:block>Virgin Islands, U.S.</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VN'">
                                                                <fo:block>Viet Nam</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VU'">
                                                                <fo:block>Vanuatu</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FI'">
                                                                <fo:block>Finland</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FJ'">
                                                                <fo:block>Fiji</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FK'">
                                                                <fo:block>Falkland Islands (Malvinas)</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SUHH'">
                                                                <fo:block>USSR</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FM'">
                                                                <fo:block>Micronesia, Federated States of</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FO'">
                                                                <fo:block>Faroe Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FR'">
                                                                <fo:block>France</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='WF'">
                                                                <fo:block>Wallis and Futuna</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GA'">
                                                                <fo:block>Gabon</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='WS'">
                                                                <fo:block>Samoa</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GD'">
                                                                <fo:block>Grenada</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GE'">
                                                                <fo:block>Georgia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GF'">
                                                                <fo:block>French Guiana</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GG'">
                                                                <fo:block>Guernsey</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GH'">
                                                                <fo:block>Ghana</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GI'">
                                                                <fo:block>Gibraltar</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GL'">
                                                                <fo:block>Greenland</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GM'">
                                                                <fo:block>Gambia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GN'">
                                                                <fo:block>Guinea</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GP'">
                                                                <fo:block>Guadeloupe</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GQ'">
                                                                <fo:block>Equatorial Guinea</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GS'">
                                                                <fo:block>South Georgia and the South Sandwich Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GT'">
                                                                <fo:block>Guatemala</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GU'">
                                                                <fo:block>Guam</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GW'">
                                                                <fo:block>Guinea-Bissau</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GY'">
                                                                <fo:block>Guyana</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='HK'">
                                                                <fo:block>Hong Kong</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='HM'">
                                                                <fo:block>Heard Island and McDonald Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='HN'">
                                                                <fo:block>Honduras</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='HR'">
                                                                <fo:block>Croatia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='HT'">
                                                                <fo:block>Haiti</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='YE'">
                                                                <fo:block>Yemen</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='HU'">
                                                                <fo:block>Hungary</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MIUM'">
                                                                <fo:block>Midway Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NQAQ'">
                                                                <fo:block>Dronning Maud Land</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ID'">
                                                                <fo:block>Indonesia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='YT'">
                                                                <fo:block>Mayotte</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IE'">
                                                                <fo:block>Ireland</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DDDE'">
                                                                <fo:block>German Democratic Republic</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IL'">
                                                                <fo:block>Israel</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IM'">
                                                                <fo:block>Isle of Man</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IN'">
                                                                <fo:block>India</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IO'">
                                                                <fo:block>British Indian Ocean Territory</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ZA'">
                                                                <fo:block>South Africa</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IQ'">
                                                                <fo:block>Iraq</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IR'">
                                                                <fo:block>Iran, Islamic Republic of</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IS'">
                                                                <fo:block>Iceland</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FQHH'">
                                                                <fo:block>French Southern and Antarctic Territories</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IT'">
                                                                <fo:block>Italy</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BUMM'">
                                                                <fo:block>Burma</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ZM'">
                                                                <fo:block>Zambia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='JE'">
                                                                <fo:block>Jersey</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ZW'">
                                                                <fo:block>Zimbabwe</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FXFR'">
                                                                <fo:block>France, Metropolitan</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='JTUM'">
                                                                <fo:block>Johnston Island</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='JM'">
                                                                <fo:block>Jamaica</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='JO'">
                                                                <fo:block>Jordan</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='JP'">
                                                                <fo:block>Japan</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KE'">
                                                                <fo:block>Kenya</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SKIN'">
                                                                <fo:block>Sikkim</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KG'">
                                                                <fo:block>Kyrgyzstan</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KH'">
                                                                <fo:block>Cambodia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KI'">
                                                                <fo:block>Kiribati</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PZPA'">
                                                                <fo:block>Panama Canal Zone</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KM'">
                                                                <fo:block>Comoros</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NTHH'">
                                                                <fo:block>Neutral Zone</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KN'">
                                                                <fo:block>Saint Kitts and Nevis</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KP'">
                                                                <fo:block>Korea, Democratic People's Republic of</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KR'">
                                                                <fo:block>Korea, Republic of</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KW'">
                                                                <fo:block>Kuwait</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KY'">
                                                                <fo:block>Cayman Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KZ'">
                                                                <fo:block>Kazakhstan</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CSHH'">
                                                                <fo:block>Czechoslovakia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CSXX'">
                                                                <fo:block>Serbia and Montenegro</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LA'">
                                                                <fo:block>Lao People's Democratic Republic</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LB'">
                                                                <fo:block>Lebanon</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LC'">
                                                                <fo:block>Saint Lucia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PUUM'">
                                                                <fo:block>Us Miscellaneous Pacific Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LI'">
                                                                <fo:block>Liechtenstein</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='YDYE'">
                                                                <fo:block>Yemen, Democratic</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LK'">
                                                                <fo:block>Sri Lanka</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LR'">
                                                                <fo:block>Liberia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LS'">
                                                                <fo:block>Lesotho</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LT'">
                                                                <fo:block>Lithuania</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LU'">
                                                                <fo:block>Luxembourg</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LV'">
                                                                <fo:block>Latvia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LY'">
                                                                <fo:block>Libya</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CTKI'">
                                                                <fo:block>Canton and Enderbury Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MA'">
                                                                <fo:block>Morocco</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MC'">
                                                                <fo:block>Monaco</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MD'">
                                                                <fo:block>Moldova, Republic of</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ME'">
                                                                <fo:block>Montenegro</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MF'">
                                                                <fo:block>Saint Martin (French part)</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MG'">
                                                                <fo:block>Madagascar</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MH'">
                                                                <fo:block>Marshall Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MK'">
                                                                <fo:block>Macedonia, the former Yugoslav Republic of</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ML'">
                                                                <fo:block>Mali</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MM'">
                                                                <fo:block>Myanmar</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MN'">
                                                                <fo:block>Mongolia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MO'">
                                                                <fo:block>Macao</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MP'">
                                                                <fo:block>Northern Mariana Islands</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MQ'">
                                                                <fo:block>Martinique</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MR'">
                                                                <fo:block>Mauritania</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MS'">
                                                                <fo:block>Montserrat</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MT'">
                                                                <fo:block>Malta</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MU'">
                                                                <fo:block>Mauritius</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MV'">
                                                                <fo:block>Maldives</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MW'">
                                                                <fo:block>Malawi</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MX'">
                                                                <fo:block>Mexico</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MY'">
                                                                <fo:block>Malaysia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MZ'">
                                                                <fo:block>Mozambique</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NA'">
                                                                <fo:block>Namibia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ZRCD'">
                                                                <fo:block>Zaire</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NC'">
                                                                <fo:block>New Caledonia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NE'">
                                                                <fo:block>Niger</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NF'">
                                                                <fo:block>Norfolk Island</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NG'">
                                                                <fo:block>Nigeria</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NI'">
                                                                <fo:block>Nicaragua</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DYBJ'">
                                                                <fo:block>Dahomey</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NL'">
                                                                <fo:block>Netherlands (the)</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NO'">
                                                                <fo:block>Norway</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NP'">
                                                                <fo:block>Nepal</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NR'">
                                                                <fo:block>Nauru</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NU'">
                                                                <fo:block>Niue</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NZ'">
                                                                <fo:block>New Zealand</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VDVN'">
                                                                <fo:block>Viet-Nam, Democratic Republic of</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TPTL'">
                                                                <fo:block>East Timor</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='RHZW'">
                                                                <fo:block>Southern Rhodesia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NHVU'">
                                                                <fo:block>New Hebrides</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='OM'">
                                                                <fo:block>Oman</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='HVBF'">
                                                                <fo:block>Upper Volta</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PA'">
                                                                <fo:block>Panama</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ANHH'">
                                                                <fo:block>Netherlands Antilles</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PE'">
                                                                <fo:block>Peru</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PF'">
                                                                <fo:block>French Polynesia</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PG'">
                                                                <fo:block>Papua New Guinea</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PH'">
                                                                <fo:block>Philippines</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PK'">
                                                                <fo:block>Pakistan</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PL'">
                                                                <fo:block>Poland</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PM'">
                                                                <fo:block>Saint Pierre and Miquelon</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PN'">
                                                                <fo:block>Pitcairn</fo:block>
                                                              </xsl:when>
                                                              <xsl:otherwise>
                                                                <fo:block>-/-</fo:block>
                                                              </xsl:otherwise>
                                                            </xsl:choose>
                                                          </fo:block>
                                                        </fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                  </fo:table-body>
                                                </fo:table>
                                              </fo:block>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>1.1.8.2. Father's family name at birth</fo:block>
                                          </fo:table-cell>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>
                                              <xsl:value-of select="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/fatherFamilyNameAtBirth"/>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>1.1.8.3. Forename of father</fo:block>
                                          </fo:table-cell>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>
                                              <xsl:value-of select="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/forenameFather"/>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>1.1.8.4. Mother's family name at birth</fo:block>
                                          </fo:table-cell>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>
                                              <xsl:value-of select="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/motherFamilyNameAtBirth"/>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>1.1.8.5. Forename of mother</fo:block>
                                          </fo:table-cell>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>
                                              <xsl:value-of select="//Person/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/forenameMother"/>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                      </fo:table-body>
                                    </fo:table>
                                  </fo:block>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                          </fo:table-body>
                        </fo:table>
                      </fo:block>
                    </fo:block>
                  </fo:table-cell>
                </fo:table-row>
                <fo:table-row>
                  <fo:table-cell number-columns-spanned="2">
                    <fo:block>
                      <fo:block>
                        <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                          <fo:table-column column-width="45%"/>
                          <fo:table-column column-width="53%"/>
                          <fo:table-header background-color="LightGrey">
                            <fo:table-row border="solid 0.2mm Grey">
                              <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                <fo:block>1.2. Additional information on the person</fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                          </fo:table-header>
                          <fo:table-body>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>1.2.1. Nationality</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//Person/AdditionalInformationPerson/nationality"/>  
                                  <fo:block>
                                    <xsl:for-each select="//Person/AdditionalInformationPerson/nationality/value">
                                      <xsl:choose>
                                        <xsl:when test=".='PS'">
                                          <fo:block>Palestine, State of</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='PT'">
                                          <fo:block>Portugal</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='PW'">
                                          <fo:block>Palau</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='PY'">
                                          <fo:block>Paraguay</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='QA'">
                                          <fo:block>Qatar</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='PCHH'">
                                          <fo:block>Pacific Islands, Trust Territory of the</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='AD'">
                                          <fo:block>Andorra</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='AE'">
                                          <fo:block>United Arab Emirates (the)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='AF'">
                                          <fo:block>Afghanistan</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='AG'">
                                          <fo:block>Antigua and Barbuda</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='AL'">
                                          <fo:block>Albania</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='AM'">
                                          <fo:block>Armenia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='AO'">
                                          <fo:block>Angola</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='AR'">
                                          <fo:block>Argentina</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='AT'">
                                          <fo:block>Austria</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='AU'">
                                          <fo:block>Australia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='AZ'">
                                          <fo:block>Azerbaijan</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='RO'">
                                          <fo:block>Romania</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BA'">
                                          <fo:block>Bosnia and Herzegovina</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BB'">
                                          <fo:block>Barbados</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='RS'">
                                          <fo:block>Serbia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BD'">
                                          <fo:block>Bangladesh</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BE'">
                                          <fo:block>Belgium</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='RU'">
                                          <fo:block>Russian Federation (the)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BF'">
                                          <fo:block>Burkina Faso</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='WKUM'">
                                          <fo:block>Wake Island</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BG'">
                                          <fo:block>Bulgaria</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='RW'">
                                          <fo:block>Rwanda</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BH'">
                                          <fo:block>Bahrain</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BI'">
                                          <fo:block>Burundi</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BJ'">
                                          <fo:block>Benin</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BN'">
                                          <fo:block>Brunei Darussalam</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BO'">
                                          <fo:block>Bolivia (Plurinational State of)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SA'">
                                          <fo:block>Saudi Arabia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SB'">
                                          <fo:block>Solomon Islands</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BR'">
                                          <fo:block>Brazil</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SC'">
                                          <fo:block>Seychelles</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BS'">
                                          <fo:block>Bahamas (the)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SD'">
                                          <fo:block>Sudan (the)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SE'">
                                          <fo:block>Sweden</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BT'">
                                          <fo:block>Bhutan</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SG'">
                                          <fo:block>Singapore</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BW'">
                                          <fo:block>Botswana</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SI'">
                                          <fo:block>Slovenia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BY'">
                                          <fo:block>Belarus</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SK'">
                                          <fo:block>Slovakia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BZ'">
                                          <fo:block>Belize</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SL'">
                                          <fo:block>Sierra Leone</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SM'">
                                          <fo:block>San Marino</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SN'">
                                          <fo:block>Senegal</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SO'">
                                          <fo:block>Somalia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CA'">
                                          <fo:block>Canada</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SR'">
                                          <fo:block>Suriname</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SS'">
                                          <fo:block>South Sudan</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CD'">
                                          <fo:block>Congo, the Democratic Republic of the</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='ST'">
                                          <fo:block>Sao Tome and Principe</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CF'">
                                          <fo:block>Central African Republic (the)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SV'">
                                          <fo:block>El Salvador</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CG'">
                                          <fo:block>Congo</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CH'">
                                          <fo:block>Switzerland</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CI'">
                                          <fo:block>Côte d'Ivoire</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SY'">
                                          <fo:block>Syrian Arab Republic</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SZ'">
                                          <fo:block>Swaziland</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CL'">
                                          <fo:block>Chile</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CM'">
                                          <fo:block>Cameroon</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CN'">
                                          <fo:block>China</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CO'">
                                          <fo:block>Colombia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CR'">
                                          <fo:block>Costa Rica</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='TD'">
                                          <fo:block>Chad</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CU'">
                                          <fo:block>Cuba</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CV'">
                                          <fo:block>Cabo Verde</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='TG'">
                                          <fo:block>Togo</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='TH'">
                                          <fo:block>Thailand</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CY'">
                                          <fo:block>Cyprus</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='TJ'">
                                          <fo:block>Tajikistan</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CZ'">
                                          <fo:block>Czechia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='TL'">
                                          <fo:block>Timor-Leste</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='TM'">
                                          <fo:block>Turkmenistan</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='TN'">
                                          <fo:block>Tunisia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='TO'">
                                          <fo:block>Tonga</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='TR'">
                                          <fo:block>Turkey</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='GEHH'">
                                          <fo:block>Gilbert and Ellice Islands</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='TT'">
                                          <fo:block>Trinidad and Tobago</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='DE'">
                                          <fo:block>Germany</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='TV'">
                                          <fo:block>Tuvalu</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='DJ'">
                                          <fo:block>Djibouti</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='TZ'">
                                          <fo:block>Tanzania, United Republic of</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='DK'">
                                          <fo:block>Denmark</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='DM'">
                                          <fo:block>Dominica</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='DO'">
                                          <fo:block>Dominican Republic (the)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='UA'">
                                          <fo:block>Ukraine</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='UG'">
                                          <fo:block>Uganda</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='UK'">
                                          <fo:block>United Kingdom</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='DZ'">
                                          <fo:block>Algeria</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='EC'">
                                          <fo:block>Ecuador</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='US'">
                                          <fo:block>United States of America (the)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='EE'">
                                          <fo:block>Estonia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BQAQ'">
                                          <fo:block>British Antarctic Territory</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='EG'">
                                          <fo:block>Egypt</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='UY'">
                                          <fo:block>Uruguay</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='UZ'">
                                          <fo:block>Uzbekistan</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='YUCS'">
                                          <fo:block>Yugoslavia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='EL'">
                                          <fo:block>Greece</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BYAA'">
                                          <fo:block>Byelorussian SSR</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='VA'">
                                          <fo:block>Holy See (the)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='ER'">
                                          <fo:block>Eritrea</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='VC'">
                                          <fo:block>Saint Vincent and the Grenadines</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='ES'">
                                          <fo:block>Spain</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='ET'">
                                          <fo:block>Ethiopia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='VE'">
                                          <fo:block>Venezuela (Bolivarian Republic of)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='AIDJ'">
                                          <fo:block>French Afar and Issas</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='VN'">
                                          <fo:block>Viet Nam</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='VU'">
                                          <fo:block>Vanuatu</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='FI'">
                                          <fo:block>Finland</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='FJ'">
                                          <fo:block>Fiji</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SUHH'">
                                          <fo:block>USSR</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='FM'">
                                          <fo:block>Micronesia (Federated States of)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='FR'">
                                          <fo:block>France</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='GA'">
                                          <fo:block>Gabon</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='WS'">
                                          <fo:block>Samoa</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='GD'">
                                          <fo:block>Grenada</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='GE'">
                                          <fo:block>Georgia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='GH'">
                                          <fo:block>Ghana</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='GM'">
                                          <fo:block>Gambia (the)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='GN'">
                                          <fo:block>Guinea</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='GQ'">
                                          <fo:block>Equatorial Guinea</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='GT'">
                                          <fo:block>Guatemala</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='GW'">
                                          <fo:block>Guinea-Bissau</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='GY'">
                                          <fo:block>Guyana</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='XR'">
                                          <fo:block>Refugee</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='XS'">
                                          <fo:block>Stateless Person</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='XU'">
                                          <fo:block>Unknown</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='HN'">
                                          <fo:block>Honduras</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='HR'">
                                          <fo:block>Croatia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='HT'">
                                          <fo:block>Haiti</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='YE'">
                                          <fo:block>Yemen</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='HU'">
                                          <fo:block>Hungary</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MIUM'">
                                          <fo:block>Midway Islands</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='NQAQ'">
                                          <fo:block>Dronning Maud Land</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='ID'">
                                          <fo:block>Indonesia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='IE'">
                                          <fo:block>Ireland</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='DDDE'">
                                          <fo:block>German Democratic Republic</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='IL'">
                                          <fo:block>Israel</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='IN'">
                                          <fo:block>India</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='ZA'">
                                          <fo:block>South Africa</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='IQ'">
                                          <fo:block>Iraq</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='IR'">
                                          <fo:block>Iran (Islamic Republic of)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='IS'">
                                          <fo:block>Iceland</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='FQHH'">
                                          <fo:block>French Southern and Antarctic Territories</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='IT'">
                                          <fo:block>Italy</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='BUMM'">
                                          <fo:block>Burma</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='ZM'">
                                          <fo:block>Zambia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='ZW'">
                                          <fo:block>Zimbabwe</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='FXFR'">
                                          <fo:block>France, Metropolitan</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='JTUM'">
                                          <fo:block>Johnston Island</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='JM'">
                                          <fo:block>Jamaica</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='JO'">
                                          <fo:block>Jordan</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='JP'">
                                          <fo:block>Japan</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='KE'">
                                          <fo:block>Kenya</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='SKIN'">
                                          <fo:block>Sikkim</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='KG'">
                                          <fo:block>Kyrgyzstan</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='KH'">
                                          <fo:block>Cambodia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='KI'">
                                          <fo:block>Kiribati</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='PZPA'">
                                          <fo:block>Panama Canal Zone</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='KM'">
                                          <fo:block>Comoros (the)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='NTHH'">
                                          <fo:block>Neutral Zone</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='KN'">
                                          <fo:block>Saint Kitts and Nevis</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='KP'">
                                          <fo:block>Korea (the Democratic People's Republic of)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='KR'">
                                          <fo:block>Korea (the Republic of)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='KW'">
                                          <fo:block>Kuwait</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='KZ'">
                                          <fo:block>Kazakhstan</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CSHH'">
                                          <fo:block>Czechoslovakia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CSXX'">
                                          <fo:block>Serbia and Montenegro</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='LA'">
                                          <fo:block>Lao People's Democratic Republic (the)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='LB'">
                                          <fo:block>Lebanon</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='LC'">
                                          <fo:block>Saint Lucia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='PUUM'">
                                          <fo:block>Us Miscellaneous Pacific Islands</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='LI'">
                                          <fo:block>Liechtenstein</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='YDYE'">
                                          <fo:block>Yemen, Democratic</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='LK'">
                                          <fo:block>Sri Lanka</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='LR'">
                                          <fo:block>Liberia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='LS'">
                                          <fo:block>Lesotho</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='LT'">
                                          <fo:block>Lithuania</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='LU'">
                                          <fo:block>Luxembourg</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='LV'">
                                          <fo:block>Latvia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='LY'">
                                          <fo:block>Libya</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='CTKI'">
                                          <fo:block>Canton and Enderbury Islands</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MA'">
                                          <fo:block>Morocco</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MC'">
                                          <fo:block>Monaco</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MD'">
                                          <fo:block>Moldova (the Republic of)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='ME'">
                                          <fo:block>Montenegro</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MG'">
                                          <fo:block>Madagascar</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MH'">
                                          <fo:block>Marshall Islands (the)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MK'">
                                          <fo:block>Macedonia (the former Yugoslav Republic of)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='ML'">
                                          <fo:block>Mali</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MM'">
                                          <fo:block>Myanmar</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MN'">
                                          <fo:block>Mongolia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MR'">
                                          <fo:block>Mauritania</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MT'">
                                          <fo:block>Malta</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MU'">
                                          <fo:block>Mauritius</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MV'">
                                          <fo:block>Maldives</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MW'">
                                          <fo:block>Malawi</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MX'">
                                          <fo:block>Mexico</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MY'">
                                          <fo:block>Malaysia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='MZ'">
                                          <fo:block>Mozambique</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='NA'">
                                          <fo:block>Namibia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='ZRCD'">
                                          <fo:block>Zaire</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='NE'">
                                          <fo:block>Niger (the)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='NG'">
                                          <fo:block>Nigeria</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='NI'">
                                          <fo:block>Nicaragua</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='DYBJ'">
                                          <fo:block>Dahomey</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='NL'">
                                          <fo:block>Netherlands</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='NO'">
                                          <fo:block>Norway</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='NP'">
                                          <fo:block>Nepal</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='NR'">
                                          <fo:block>Nauru</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='NZ'">
                                          <fo:block>New Zealand</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='VDVN'">
                                          <fo:block>Viet-Nam, Democratic Republic of</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='TPTL'">
                                          <fo:block>East Timor</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='RHZW'">
                                          <fo:block>Southern Rhodesia</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='NHVU'">
                                          <fo:block>New Hebrides</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='OM'">
                                          <fo:block>Oman</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='HVBF'">
                                          <fo:block>Upper Volta</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='PA'">
                                          <fo:block>Panama</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='ANHH'">
                                          <fo:block>Netherlands Antilles</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='PE'">
                                          <fo:block>Peru</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='PG'">
                                          <fo:block>Papua New Guinea</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='PH'">
                                          <fo:block>Philippines (the)</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='PK'">
                                          <fo:block>Pakistan</fo:block>
                                        </xsl:when>
                                        <xsl:when test=".='PL'">
                                          <fo:block>Poland</fo:block>
                                        </xsl:when>
                                        <xsl:otherwise>
                                          <fo:block>-/-</fo:block>
                                        </xsl:otherwise>
                                      </xsl:choose>
                                    </xsl:for-each>
                                  </fo:block>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                          </fo:table-body>
                        </fo:table>
                      </fo:block>
                    </fo:block>
                  </fo:table-cell>
                </fo:table-row>
              </fo:table-body>
            </fo:table>
          </fo:block>
          <fo:block>
            <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
              <fo:table-column column-width="45%"/>
              <fo:table-column column-width="53%"/>
              <fo:table-header background-color="LightGrey">
                <fo:table-row border="solid 0.2mm Grey">
                  <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm" font-weight="bold">
                    <fo:block>2. Address (of the person for whom information on registration is sent)</fo:block>
                  </fo:table-cell>
                </fo:table-row>
              </fo:table-header>
              <fo:table-body>
                <fo:table-row>
                  <fo:table-cell number-columns-spanned="2">
                    <fo:block>
                      <fo:block>
                        <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                          <fo:table-column column-width="45%"/>
                          <fo:table-column column-width="53%"/>
                          <fo:table-header background-color="LightGrey">
                            <fo:table-row border="solid 0.2mm Grey">
                              <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                <fo:block>2.1. Address</fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                          </fo:table-header>
                          <fo:table-body>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>2.1.1. Street</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//AddressOfPersonForWhomInformationRegistrationSent/Address/street"/>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>2.1.2. Building Name</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//AddressOfPersonForWhomInformationRegistrationSent/Address/buildingName"/>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>2.1.3. Town</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//AddressOfPersonForWhomInformationRegistrationSent/Address/town"/>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>2.1.4. Postal Code</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//AddressOfPersonForWhomInformationRegistrationSent/Address/postalCode"/>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>2.1.5. Region</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//AddressOfPersonForWhomInformationRegistrationSent/Address/region"/>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>2.1.6. Country</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//AddressOfPersonForWhomInformationRegistrationSent/Address/country"/>  
                                  <fo:block>
                                    <xsl:choose>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='DE'">
                                        <fo:block>Germany</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='NO'">
                                        <fo:block>Norway</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='BE'">
                                        <fo:block>Belgium</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='FI'">
                                        <fo:block>Finland</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='PT'">
                                        <fo:block>Portugal</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='BG'">
                                        <fo:block>Bulgaria</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='DK'">
                                        <fo:block>Denmark</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='LT'">
                                        <fo:block>Lithuania</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='LU'">
                                        <fo:block>Luxembourg</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='HR'">
                                        <fo:block>Croatia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='LV'">
                                        <fo:block>Latvia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='FR'">
                                        <fo:block>France</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='HU'">
                                        <fo:block>Hungary</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='SE'">
                                        <fo:block>Sweden</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='SI'">
                                        <fo:block>Slovenia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='UK'">
                                        <fo:block>United Kingdom</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='SK'">
                                        <fo:block>Slovakia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='IE'">
                                        <fo:block>Ireland</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='EE'">
                                        <fo:block>Estonia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='CH'">
                                        <fo:block>Switzerland</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='EL'">
                                        <fo:block>Greece</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='MT'">
                                        <fo:block>Malta</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='IS'">
                                        <fo:block>Iceland</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='IT'">
                                        <fo:block>Italy</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='ES'">
                                        <fo:block>Spain</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='AT'">
                                        <fo:block>Austria</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='CY'">
                                        <fo:block>Cyprus</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='CZ'">
                                        <fo:block>Czechia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='PL'">
                                        <fo:block>Poland</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='LI'">
                                        <fo:block>Liechtenstein</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='RO'">
                                        <fo:block>Romania</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//AddressOfPersonForWhomInformationRegistrationSent/Address/country/value='NL'">
                                        <fo:block>Netherlands</fo:block>
                                      </xsl:when>
                                      <xsl:otherwise>
                                        <fo:block>-/-</fo:block>
                                      </xsl:otherwise>
                                    </xsl:choose>
                                  </fo:block>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                          </fo:table-body>
                        </fo:table>
                      </fo:block>
                    </fo:block>
                  </fo:table-cell>
                </fo:table-row>
                <fo:table-row>
                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                    <fo:block>2.2. Residence in this country since</fo:block>
                  </fo:table-cell>
                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                    <fo:block>
                      <xsl:value-of select="//AddressOfPersonForWhomInformationRegistrationSent/residenceInThisCountrySince"/>
                    </fo:block>
                  </fo:table-cell>
                </fo:table-row>
              </fo:table-body>
            </fo:table>
          </fo:block>
          <fo:block>
            <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
              <fo:table-column column-width="45%"/>
              <fo:table-column column-width="53%"/>
              <fo:table-header background-color="LightGrey">
                <fo:table-row border="solid 0.2mm Grey">
                  <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm" font-weight="bold">
                    <fo:block>3. Status</fo:block>
                  </fo:table-cell>
                </fo:table-row>
              </fo:table-header>
              <fo:table-body>
                <fo:table-row>
                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                    <fo:block>3.1. status</fo:block>
                  </fo:table-cell>
                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                    <fo:block>
                      <xsl:value-of select="//Status/status"/>  
                      <fo:block>
                        <xsl:choose>
                          <xsl:when test="//Status/status/value='01'">
                            <fo:block>Insured person</fo:block>
                          </xsl:when>
                          <xsl:when test="//Status/status/value='02'">
                            <fo:block>Family member of insured person</fo:block>
                          </xsl:when>
                          <xsl:when test="//Status/status/value='03'">
                            <fo:block>Pensioner</fo:block>
                          </xsl:when>
                          <xsl:when test="//Status/status/value='04'">
                            <fo:block>Family member of pensioner</fo:block>
                          </xsl:when>
                          <xsl:when test="//Status/status/value='05'">
                            <fo:block>Pension claimant</fo:block>
                          </xsl:when>
                          <xsl:otherwise>
                            <fo:block>-/-</fo:block>
                          </xsl:otherwise>
                        </xsl:choose>
                      </fo:block>
                    </fo:block>
                  </fo:table-cell>
                </fo:table-row>
              </fo:table-body>
            </fo:table>
          </fo:block>
          <fo:block>
            <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
              <fo:table-column column-width="45%"/>
              <fo:table-column column-width="53%"/>
              <fo:table-header background-color="LightGrey">
                <fo:table-row border="solid 0.2mm Grey">
                  <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm" font-weight="bold">
                    <fo:block>4. Please fill in the following if "Status of the person" = "Family member of insured person" or "Status of the person" = "Family member of pensioner" :</fo:block>
                  </fo:table-cell>
                </fo:table-row>
              </fo:table-header>
              <fo:table-body>
                <fo:table-row>
                  <fo:table-cell number-columns-spanned="2">
                    <fo:block>
                      <fo:block>
                        <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                          <fo:table-column column-width="45%"/>
                          <fo:table-column column-width="53%"/>
                          <fo:table-header background-color="LightGrey">
                            <fo:table-row border="solid 0.2mm Grey">
                              <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                <fo:block>4.1. Insured Person</fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                          </fo:table-header>
                          <fo:table-body>
                            <fo:table-row>
                              <fo:table-cell number-columns-spanned="2">
                                <fo:block>
                                  <fo:block>
                                    <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                      <fo:table-column column-width="45%"/>
                                      <fo:table-column column-width="53%"/>
                                      <fo:table-header background-color="LightGrey">
                                        <fo:table-row border="solid 0.2mm Grey">
                                          <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>4.1.1. Person Identification</fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                      </fo:table-header>
                                      <fo:table-body>
                                        <fo:table-row>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>4.1.1.1. Family name(s)</fo:block>
                                          </fo:table-cell>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>
                                              <xsl:value-of select="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/familyName"/>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>4.1.1.2. Forename(s)</fo:block>
                                          </fo:table-cell>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>
                                              <xsl:value-of select="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/forename"/>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>4.1.1.3. Date of birth</fo:block>
                                          </fo:table-cell>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>
                                              <xsl:value-of select="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/dateBirth"/>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>4.1.1.4. Sex</fo:block>
                                          </fo:table-cell>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>
                                              <xsl:value-of select="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/sex"/>  
                                              <fo:block>
                                                <xsl:choose>
                                                  <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/sex/value='01'">
                                                    <fo:block>Male</fo:block>
                                                  </xsl:when>
                                                  <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/sex/value='02'">
                                                    <fo:block>Female</fo:block>
                                                  </xsl:when>
                                                  <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/sex/value='98'">
                                                    <fo:block>Unknown</fo:block>
                                                  </xsl:when>
                                                  <xsl:otherwise>
                                                    <fo:block>-/-</fo:block>
                                                  </xsl:otherwise>
                                                </xsl:choose>
                                              </fo:block>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>4.1.1.5. Family name(s) at birth</fo:block>
                                          </fo:table-cell>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>
                                              <xsl:value-of select="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/familyNameAtBirth"/>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>4.1.1.6. Forename(s) at birth</fo:block>
                                          </fo:table-cell>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>
                                              <xsl:value-of select="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/forenameAtBirth"/>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                          <fo:table-cell number-columns-spanned="2">
                                            <fo:block>
                                              <fo:block>
                                                <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                                  <fo:table-column column-width="45%"/>
                                                  <fo:table-column column-width="53%"/>
                                                  <fo:table-header background-color="LightGrey">
                                                    <fo:table-row border="solid 0.2mm Grey">
                                                      <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>4.1.1.7. PIN of the person in each institution</fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                  </fo:table-header>
                                                  <fo:table-body>
                                                    <xsl:for-each select="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/PINPersonInEachInstitution/PersonalIdentificationNumber">
                                                      <fo:table-row>
                                                        <fo:table-cell number-columns-spanned="2">
                                                          <fo:block>
                                                            <fo:block>
                                                              <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                                                <fo:table-column column-width="45%"/>
                                                                <fo:table-column column-width="53%"/>
                                                                <fo:table-header background-color="LightGrey">
                                                                  <fo:table-row border="solid 0.2mm Grey">
                                                                    <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                                                      <fo:block>4.1.1.7.1.[
                                                                        <xsl:value-of select="position()"/>] Personal Identification Number(s)
                                                                      </fo:block>
                                                                    </fo:table-cell>
                                                                  </fo:table-row>
                                                                </fo:table-header>
                                                                <fo:table-body>
                                                                  <fo:table-row>
                                                                    <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                      <fo:block>4.1.1.7.1.1.[
                                                                        <xsl:value-of select="position()"/>] Country
                                                                      </fo:block>
                                                                    </fo:table-cell>
                                                                    <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                      <fo:block>
                                                                        <xsl:value-of select="country"/>  
                                                                        <fo:block>
                                                                          <xsl:choose>
                                                                            <xsl:when test="country/value='DE'">
                                                                              <fo:block>Germany</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='NO'">
                                                                              <fo:block>Norway</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='BE'">
                                                                              <fo:block>Belgium</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='FI'">
                                                                              <fo:block>Finland</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='PT'">
                                                                              <fo:block>Portugal</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='BG'">
                                                                              <fo:block>Bulgaria</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='DK'">
                                                                              <fo:block>Denmark</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='LT'">
                                                                              <fo:block>Lithuania</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='LU'">
                                                                              <fo:block>Luxembourg</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='HR'">
                                                                              <fo:block>Croatia</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='LV'">
                                                                              <fo:block>Latvia</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='FR'">
                                                                              <fo:block>France</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='HU'">
                                                                              <fo:block>Hungary</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='SE'">
                                                                              <fo:block>Sweden</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='SI'">
                                                                              <fo:block>Slovenia</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='UK'">
                                                                              <fo:block>United Kingdom</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='SK'">
                                                                              <fo:block>Slovakia</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='IE'">
                                                                              <fo:block>Ireland</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='EE'">
                                                                              <fo:block>Estonia</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='CH'">
                                                                              <fo:block>Switzerland</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='EL'">
                                                                              <fo:block>Greece</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='MT'">
                                                                              <fo:block>Malta</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='IS'">
                                                                              <fo:block>Iceland</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='IT'">
                                                                              <fo:block>Italy</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='ES'">
                                                                              <fo:block>Spain</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='AT'">
                                                                              <fo:block>Austria</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='CY'">
                                                                              <fo:block>Cyprus</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='CZ'">
                                                                              <fo:block>Czechia</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='PL'">
                                                                              <fo:block>Poland</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='LI'">
                                                                              <fo:block>Liechtenstein</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='RO'">
                                                                              <fo:block>Romania</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="country/value='NL'">
                                                                              <fo:block>Netherlands</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:otherwise>
                                                                              <fo:block>-/-</fo:block>
                                                                            </xsl:otherwise>
                                                                          </xsl:choose>
                                                                        </fo:block>
                                                                      </fo:block>
                                                                    </fo:table-cell>
                                                                  </fo:table-row>
                                                                  <fo:table-row>
                                                                    <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                      <fo:block>4.1.1.7.1.2.[
                                                                        <xsl:value-of select="position()"/>] Personal Identification Number (PIN)
                                                                      </fo:block>
                                                                    </fo:table-cell>
                                                                    <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                      <fo:block>
                                                                        <xsl:value-of select="personalIdentificationNumber"/>
                                                                      </fo:block>
                                                                    </fo:table-cell>
                                                                  </fo:table-row>
                                                                  <fo:table-row>
                                                                    <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                      <fo:block>4.1.1.7.1.3.[
                                                                        <xsl:value-of select="position()"/>] Sector
                                                                      </fo:block>
                                                                    </fo:table-cell>
                                                                    <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                      <fo:block>
                                                                        <xsl:value-of select="sector"/>  
                                                                        <fo:block>
                                                                          <xsl:choose>
                                                                            <xsl:when test="sector/value='01'">
                                                                              <fo:block>AWOD</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="sector/value='02'">
                                                                              <fo:block>Family Benefits</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="sector/value='03'">
                                                                              <fo:block>All</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="sector/value='04'">
                                                                              <fo:block>Pensions</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="sector/value='05'">
                                                                              <fo:block>Recovery</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="sector/value='06'">
                                                                              <fo:block>Sickness</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:when test="sector/value='07'">
                                                                              <fo:block>Unemployment Benefits</fo:block>
                                                                            </xsl:when>
                                                                            <xsl:otherwise>
                                                                              <fo:block>-/-</fo:block>
                                                                            </xsl:otherwise>
                                                                          </xsl:choose>
                                                                        </fo:block>
                                                                      </fo:block>
                                                                    </fo:table-cell>
                                                                  </fo:table-row>
                                                                  <fo:table-row>
                                                                    <fo:table-cell number-columns-spanned="2">
                                                                      <fo:block>
                                                                        <fo:block>
                                                                          <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                                                            <fo:table-column column-width="45%"/>
                                                                            <fo:table-column column-width="53%"/>
                                                                            <fo:table-header background-color="LightGrey">
                                                                              <fo:table-row border="solid 0.2mm Grey">
                                                                                <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                                                                  <fo:block>4.1.1.7.1.4.[
                                                                                    <xsl:value-of select="position()"/>] Institution
                                                                                  </fo:block>
                                                                                </fo:table-cell>
                                                                              </fo:table-row>
                                                                            </fo:table-header>
                                                                            <fo:table-body>
                                                                              <fo:table-row>
                                                                                <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                                  <fo:block>4.1.1.7.1.4.1.[
                                                                                    <xsl:value-of select="position()"/>] Institution ID
                                                                                  </fo:block>
                                                                                </fo:table-cell>
                                                                                <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                                  <fo:block>
                                                                                    <xsl:value-of select="Institution/institutionID"/>
                                                                                  </fo:block>
                                                                                </fo:table-cell>
                                                                              </fo:table-row>
                                                                              <fo:table-row>
                                                                                <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                                  <fo:block>4.1.1.7.1.4.2.[
                                                                                    <xsl:value-of select="position()"/>] Institution Name
                                                                                  </fo:block>
                                                                                </fo:table-cell>
                                                                                <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                                  <fo:block>
                                                                                    <xsl:value-of select="Institution/institutionName"/>
                                                                                  </fo:block>
                                                                                </fo:table-cell>
                                                                              </fo:table-row>
                                                                            </fo:table-body>
                                                                          </fo:table>
                                                                        </fo:block>
                                                                      </fo:block>
                                                                    </fo:table-cell>
                                                                  </fo:table-row>
                                                                </fo:table-body>
                                                              </fo:table>
                                                            </fo:block>
                                                          </fo:block>
                                                        </fo:table-cell>
                                                      </fo:table-row>
                                                    </xsl:for-each>
                                                    <xsl:if test="not(//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/PINPersonInEachInstitution/PersonalIdentificationNumber)">
                                                      <fo:table-row>
                                                        <fo:table-cell number-columns-spanned="2">
                                                          <fo:block/>
                                                        </fo:table-cell>
                                                      </fo:table-row>
                                                    </xsl:if>
                                                  </fo:table-body>
                                                </fo:table>
                                              </fo:block>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                          <fo:table-cell number-columns-spanned="2">
                                            <fo:block>
                                              <fo:block>
                                                <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                                  <fo:table-column column-width="45%"/>
                                                  <fo:table-column column-width="53%"/>
                                                  <fo:table-header background-color="LightGrey">
                                                    <fo:table-row border="solid 0.2mm Grey">
                                                      <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>4.1.1.8. If PIN not provided for every institution, please provide</fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                  </fo:table-header>
                                                  <fo:table-body>
                                                    <fo:table-row>
                                                      <fo:table-cell number-columns-spanned="2">
                                                        <fo:block>
                                                          <fo:block>
                                                            <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                                              <fo:table-column column-width="45%"/>
                                                              <fo:table-column column-width="53%"/>
                                                              <fo:table-header background-color="LightGrey">
                                                                <fo:table-row border="solid 0.2mm Grey">
                                                                  <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                                                    <fo:block>4.1.1.8.1. Place of birth</fo:block>
                                                                  </fo:table-cell>
                                                                </fo:table-row>
                                                              </fo:table-header>
                                                              <fo:table-body>
                                                                <fo:table-row>
                                                                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                    <fo:block>4.1.1.8.1.1. Town</fo:block>
                                                                  </fo:table-cell>
                                                                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                    <fo:block>
                                                                      <xsl:value-of select="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/town"/>
                                                                    </fo:block>
                                                                  </fo:table-cell>
                                                                </fo:table-row>
                                                                <fo:table-row>
                                                                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                    <fo:block>4.1.1.8.1.2. Region</fo:block>
                                                                  </fo:table-cell>
                                                                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                    <fo:block>
                                                                      <xsl:value-of select="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/region"/>
                                                                    </fo:block>
                                                                  </fo:table-cell>
                                                                </fo:table-row>
                                                                <fo:table-row>
                                                                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                    <fo:block>4.1.1.8.1.3. Country</fo:block>
                                                                  </fo:table-cell>
                                                                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                                    <fo:block>
                                                                      <xsl:value-of select="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country"/>  
                                                                      <fo:block>
                                                                        <xsl:choose>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PR'">
                                                                            <fo:block>Puerto Rico</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PS'">
                                                                            <fo:block>Palestine, State of</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PT'">
                                                                            <fo:block>Portugal</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PW'">
                                                                            <fo:block>Palau</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PY'">
                                                                            <fo:block>Paraguay</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='QA'">
                                                                            <fo:block>Qatar</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PCHH'">
                                                                            <fo:block>Pacific Islands, Trust Territory of the</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AD'">
                                                                            <fo:block>Andorra</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AE'">
                                                                            <fo:block>United Arab Emirates</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AF'">
                                                                            <fo:block>Afghanistan</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AG'">
                                                                            <fo:block>Antigua and Barbuda</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AI'">
                                                                            <fo:block>Anguilla</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AL'">
                                                                            <fo:block>Albania</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AM'">
                                                                            <fo:block>Armenia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AO'">
                                                                            <fo:block>Angola</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AQ'">
                                                                            <fo:block>Antarctica</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AR'">
                                                                            <fo:block>Argentina</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AS'">
                                                                            <fo:block>American Samoa</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AT'">
                                                                            <fo:block>Austria</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='RE'">
                                                                            <fo:block>Réunion</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AU'">
                                                                            <fo:block>Australia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AW'">
                                                                            <fo:block>Aruba</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AX'">
                                                                            <fo:block>Aland Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AZ'">
                                                                            <fo:block>Azerbaijan</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='RO'">
                                                                            <fo:block>Romania</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BA'">
                                                                            <fo:block>Bosnia and Herzegovina</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BB'">
                                                                            <fo:block>Barbados</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='RS'">
                                                                            <fo:block>Serbia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BD'">
                                                                            <fo:block>Bangladesh</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BE'">
                                                                            <fo:block>Belgium</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='RU'">
                                                                            <fo:block>Russian Federation</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BF'">
                                                                            <fo:block>Burkina Faso</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='WKUM'">
                                                                            <fo:block>Wake Island</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BG'">
                                                                            <fo:block>Bulgaria</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='RW'">
                                                                            <fo:block>Rwanda</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BH'">
                                                                            <fo:block>Bahrain</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BI'">
                                                                            <fo:block>Burundi</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BJ'">
                                                                            <fo:block>Benin</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BL'">
                                                                            <fo:block>Saint Barthélemy</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BM'">
                                                                            <fo:block>Bermuda</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BN'">
                                                                            <fo:block>Brunei Darussalam</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BO'">
                                                                            <fo:block>Bolivia, Plurinational State of</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SA'">
                                                                            <fo:block>Saudi Arabia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BQ'">
                                                                            <fo:block>Bonaire, Sint Eustatius and Saba</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SB'">
                                                                            <fo:block>Solomon Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BR'">
                                                                            <fo:block>Brazil</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SC'">
                                                                            <fo:block>Seychelles</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BS'">
                                                                            <fo:block>Bahamas</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SD'">
                                                                            <fo:block>Sudan</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SE'">
                                                                            <fo:block>Sweden</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BT'">
                                                                            <fo:block>Bhutan</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BV'">
                                                                            <fo:block>Bouvet Island</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SG'">
                                                                            <fo:block>Singapore</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BW'">
                                                                            <fo:block>Botswana</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SH'">
                                                                            <fo:block>Saint Helena, Ascension and Tristan da Cunha</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SI'">
                                                                            <fo:block>Slovenia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BY'">
                                                                            <fo:block>Belarus</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SJ'">
                                                                            <fo:block>Svalbard and Jan Mayen</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SK'">
                                                                            <fo:block>Slovakia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BZ'">
                                                                            <fo:block>Belize</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SL'">
                                                                            <fo:block>Sierra Leone</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SM'">
                                                                            <fo:block>San Marino</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SN'">
                                                                            <fo:block>Senegal</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SO'">
                                                                            <fo:block>Somalia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CA'">
                                                                            <fo:block>Canada</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SR'">
                                                                            <fo:block>Suriname</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CC'">
                                                                            <fo:block>Cocos (Keeling) Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SS'">
                                                                            <fo:block>South Sudan</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CD'">
                                                                            <fo:block>Congo, the Democratic Republic of the</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ST'">
                                                                            <fo:block>Sao Tome and Principe</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CF'">
                                                                            <fo:block>Central African Republic</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SV'">
                                                                            <fo:block>El Salvador</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CG'">
                                                                            <fo:block>Congo</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CH'">
                                                                            <fo:block>Switzerland</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SX'">
                                                                            <fo:block>Sint Maarten (Dutch part)</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CI'">
                                                                            <fo:block>Côte d'Ivoire</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SY'">
                                                                            <fo:block>Syrian Arab Republic</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SZ'">
                                                                            <fo:block>Swaziland</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CK'">
                                                                            <fo:block>Cook Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CL'">
                                                                            <fo:block>Chile</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CM'">
                                                                            <fo:block>Cameroon</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CN'">
                                                                            <fo:block>China</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CO'">
                                                                            <fo:block>Colombia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CR'">
                                                                            <fo:block>Costa Rica</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TC'">
                                                                            <fo:block>Turks and Caicos Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TD'">
                                                                            <fo:block>Chad</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CU'">
                                                                            <fo:block>Cuba</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TF'">
                                                                            <fo:block>French Southern Territories</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CV'">
                                                                            <fo:block>Cape Verde</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TG'">
                                                                            <fo:block>Togo</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CW'">
                                                                            <fo:block>Curaçao</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TH'">
                                                                            <fo:block>Thailand</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CX'">
                                                                            <fo:block>Christmas Island</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CY'">
                                                                            <fo:block>Cyprus</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TJ'">
                                                                            <fo:block>Tajikistan</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CZ'">
                                                                            <fo:block>Czech Republic</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TK'">
                                                                            <fo:block>Tokelau</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TL'">
                                                                            <fo:block>Timor-Leste</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TM'">
                                                                            <fo:block>Turkmenistan</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TN'">
                                                                            <fo:block>Tunisia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TO'">
                                                                            <fo:block>Tonga</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TR'">
                                                                            <fo:block>Turkey</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GEHH'">
                                                                            <fo:block>Gilbert and Ellice Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TT'">
                                                                            <fo:block>Trinidad and Tobago</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DE'">
                                                                            <fo:block>Germany</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TV'">
                                                                            <fo:block>Tuvalu</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TW'">
                                                                            <fo:block>Taiwan, Province of China</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DJ'">
                                                                            <fo:block>Djibouti</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TZ'">
                                                                            <fo:block>Tanzania, United Republic of</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DK'">
                                                                            <fo:block>Denmark</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DM'">
                                                                            <fo:block>Dominica</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DO'">
                                                                            <fo:block>Dominican Republic</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='UA'">
                                                                            <fo:block>Ukraine</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='UG'">
                                                                            <fo:block>Uganda</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='UK'">
                                                                            <fo:block>United Kingdom</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DZ'">
                                                                            <fo:block>Algeria</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='UM'">
                                                                            <fo:block>United States Minor Outlying Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='EC'">
                                                                            <fo:block>Ecuador</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='US'">
                                                                            <fo:block>United States of America</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='EE'">
                                                                            <fo:block>Estonia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BQAQ'">
                                                                            <fo:block>British Antarctic Territory</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='EG'">
                                                                            <fo:block>Egypt</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='EH'">
                                                                            <fo:block>Western Sahara</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='UY'">
                                                                            <fo:block>Uruguay</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='UZ'">
                                                                            <fo:block>Uzbekistan</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='YUCS'">
                                                                            <fo:block>Yugoslavia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='EL'">
                                                                            <fo:block>Greece</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BYAA'">
                                                                            <fo:block>Byelorussian SSR</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VA'">
                                                                            <fo:block>Holy See</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ER'">
                                                                            <fo:block>Eritrea</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VC'">
                                                                            <fo:block>Saint Vincent and the Grenadines</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ES'">
                                                                            <fo:block>Spain</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ET'">
                                                                            <fo:block>Ethiopia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VE'">
                                                                            <fo:block>Venezuela, Bolivarian Republic of</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='AIDJ'">
                                                                            <fo:block>French Afar and Issas</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VG'">
                                                                            <fo:block>Virgin Islands, British</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VI'">
                                                                            <fo:block>Virgin Islands, U.S.</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VN'">
                                                                            <fo:block>Viet Nam</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VU'">
                                                                            <fo:block>Vanuatu</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FI'">
                                                                            <fo:block>Finland</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FJ'">
                                                                            <fo:block>Fiji</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FK'">
                                                                            <fo:block>Falkland Islands (Malvinas)</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SUHH'">
                                                                            <fo:block>USSR</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FM'">
                                                                            <fo:block>Micronesia, Federated States of</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FO'">
                                                                            <fo:block>Faroe Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FR'">
                                                                            <fo:block>France</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='WF'">
                                                                            <fo:block>Wallis and Futuna</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GA'">
                                                                            <fo:block>Gabon</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='WS'">
                                                                            <fo:block>Samoa</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GD'">
                                                                            <fo:block>Grenada</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GE'">
                                                                            <fo:block>Georgia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GF'">
                                                                            <fo:block>French Guiana</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GG'">
                                                                            <fo:block>Guernsey</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GH'">
                                                                            <fo:block>Ghana</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GI'">
                                                                            <fo:block>Gibraltar</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GL'">
                                                                            <fo:block>Greenland</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GM'">
                                                                            <fo:block>Gambia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GN'">
                                                                            <fo:block>Guinea</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GP'">
                                                                            <fo:block>Guadeloupe</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GQ'">
                                                                            <fo:block>Equatorial Guinea</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GS'">
                                                                            <fo:block>South Georgia and the South Sandwich Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GT'">
                                                                            <fo:block>Guatemala</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GU'">
                                                                            <fo:block>Guam</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GW'">
                                                                            <fo:block>Guinea-Bissau</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='GY'">
                                                                            <fo:block>Guyana</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='HK'">
                                                                            <fo:block>Hong Kong</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='HM'">
                                                                            <fo:block>Heard Island and McDonald Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='HN'">
                                                                            <fo:block>Honduras</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='HR'">
                                                                            <fo:block>Croatia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='HT'">
                                                                            <fo:block>Haiti</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='YE'">
                                                                            <fo:block>Yemen</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='HU'">
                                                                            <fo:block>Hungary</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MIUM'">
                                                                            <fo:block>Midway Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NQAQ'">
                                                                            <fo:block>Dronning Maud Land</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ID'">
                                                                            <fo:block>Indonesia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='YT'">
                                                                            <fo:block>Mayotte</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IE'">
                                                                            <fo:block>Ireland</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DDDE'">
                                                                            <fo:block>German Democratic Republic</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IL'">
                                                                            <fo:block>Israel</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IM'">
                                                                            <fo:block>Isle of Man</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IN'">
                                                                            <fo:block>India</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IO'">
                                                                            <fo:block>British Indian Ocean Territory</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ZA'">
                                                                            <fo:block>South Africa</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IQ'">
                                                                            <fo:block>Iraq</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IR'">
                                                                            <fo:block>Iran, Islamic Republic of</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IS'">
                                                                            <fo:block>Iceland</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FQHH'">
                                                                            <fo:block>French Southern and Antarctic Territories</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='IT'">
                                                                            <fo:block>Italy</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='BUMM'">
                                                                            <fo:block>Burma</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ZM'">
                                                                            <fo:block>Zambia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='JE'">
                                                                            <fo:block>Jersey</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ZW'">
                                                                            <fo:block>Zimbabwe</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='FXFR'">
                                                                            <fo:block>France, Metropolitan</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='JTUM'">
                                                                            <fo:block>Johnston Island</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='JM'">
                                                                            <fo:block>Jamaica</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='JO'">
                                                                            <fo:block>Jordan</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='JP'">
                                                                            <fo:block>Japan</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KE'">
                                                                            <fo:block>Kenya</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='SKIN'">
                                                                            <fo:block>Sikkim</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KG'">
                                                                            <fo:block>Kyrgyzstan</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KH'">
                                                                            <fo:block>Cambodia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KI'">
                                                                            <fo:block>Kiribati</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PZPA'">
                                                                            <fo:block>Panama Canal Zone</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KM'">
                                                                            <fo:block>Comoros</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NTHH'">
                                                                            <fo:block>Neutral Zone</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KN'">
                                                                            <fo:block>Saint Kitts and Nevis</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KP'">
                                                                            <fo:block>Korea, Democratic People's Republic of</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KR'">
                                                                            <fo:block>Korea, Republic of</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KW'">
                                                                            <fo:block>Kuwait</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KY'">
                                                                            <fo:block>Cayman Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='KZ'">
                                                                            <fo:block>Kazakhstan</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CSHH'">
                                                                            <fo:block>Czechoslovakia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CSXX'">
                                                                            <fo:block>Serbia and Montenegro</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LA'">
                                                                            <fo:block>Lao People's Democratic Republic</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LB'">
                                                                            <fo:block>Lebanon</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LC'">
                                                                            <fo:block>Saint Lucia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PUUM'">
                                                                            <fo:block>Us Miscellaneous Pacific Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LI'">
                                                                            <fo:block>Liechtenstein</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='YDYE'">
                                                                            <fo:block>Yemen, Democratic</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LK'">
                                                                            <fo:block>Sri Lanka</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LR'">
                                                                            <fo:block>Liberia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LS'">
                                                                            <fo:block>Lesotho</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LT'">
                                                                            <fo:block>Lithuania</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LU'">
                                                                            <fo:block>Luxembourg</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LV'">
                                                                            <fo:block>Latvia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='LY'">
                                                                            <fo:block>Libya</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='CTKI'">
                                                                            <fo:block>Canton and Enderbury Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MA'">
                                                                            <fo:block>Morocco</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MC'">
                                                                            <fo:block>Monaco</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MD'">
                                                                            <fo:block>Moldova, Republic of</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ME'">
                                                                            <fo:block>Montenegro</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MF'">
                                                                            <fo:block>Saint Martin (French part)</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MG'">
                                                                            <fo:block>Madagascar</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MH'">
                                                                            <fo:block>Marshall Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MK'">
                                                                            <fo:block>Macedonia, the former Yugoslav Republic of</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ML'">
                                                                            <fo:block>Mali</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MM'">
                                                                            <fo:block>Myanmar</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MN'">
                                                                            <fo:block>Mongolia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MO'">
                                                                            <fo:block>Macao</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MP'">
                                                                            <fo:block>Northern Mariana Islands</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MQ'">
                                                                            <fo:block>Martinique</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MR'">
                                                                            <fo:block>Mauritania</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MS'">
                                                                            <fo:block>Montserrat</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MT'">
                                                                            <fo:block>Malta</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MU'">
                                                                            <fo:block>Mauritius</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MV'">
                                                                            <fo:block>Maldives</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MW'">
                                                                            <fo:block>Malawi</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MX'">
                                                                            <fo:block>Mexico</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MY'">
                                                                            <fo:block>Malaysia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='MZ'">
                                                                            <fo:block>Mozambique</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NA'">
                                                                            <fo:block>Namibia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ZRCD'">
                                                                            <fo:block>Zaire</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NC'">
                                                                            <fo:block>New Caledonia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NE'">
                                                                            <fo:block>Niger</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NF'">
                                                                            <fo:block>Norfolk Island</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NG'">
                                                                            <fo:block>Nigeria</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NI'">
                                                                            <fo:block>Nicaragua</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='DYBJ'">
                                                                            <fo:block>Dahomey</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NL'">
                                                                            <fo:block>Netherlands (the)</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NO'">
                                                                            <fo:block>Norway</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NP'">
                                                                            <fo:block>Nepal</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NR'">
                                                                            <fo:block>Nauru</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NU'">
                                                                            <fo:block>Niue</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NZ'">
                                                                            <fo:block>New Zealand</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='VDVN'">
                                                                            <fo:block>Viet-Nam, Democratic Republic of</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='TPTL'">
                                                                            <fo:block>East Timor</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='RHZW'">
                                                                            <fo:block>Southern Rhodesia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='NHVU'">
                                                                            <fo:block>New Hebrides</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='OM'">
                                                                            <fo:block>Oman</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='HVBF'">
                                                                            <fo:block>Upper Volta</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PA'">
                                                                            <fo:block>Panama</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='ANHH'">
                                                                            <fo:block>Netherlands Antilles</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PE'">
                                                                            <fo:block>Peru</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PF'">
                                                                            <fo:block>French Polynesia</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PG'">
                                                                            <fo:block>Papua New Guinea</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PH'">
                                                                            <fo:block>Philippines</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PK'">
                                                                            <fo:block>Pakistan</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PL'">
                                                                            <fo:block>Poland</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PM'">
                                                                            <fo:block>Saint Pierre and Miquelon</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:when test="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/PlaceBirth/country/value='PN'">
                                                                            <fo:block>Pitcairn</fo:block>
                                                                          </xsl:when>
                                                                          <xsl:otherwise>
                                                                            <fo:block>-/-</fo:block>
                                                                          </xsl:otherwise>
                                                                        </xsl:choose>
                                                                      </fo:block>
                                                                    </fo:block>
                                                                  </fo:table-cell>
                                                                </fo:table-row>
                                                              </fo:table-body>
                                                            </fo:table>
                                                          </fo:block>
                                                        </fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                    <fo:table-row>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>4.1.1.8.2. Father's family name at birth</fo:block>
                                                      </fo:table-cell>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>
                                                          <xsl:value-of select="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/fatherFamilyNameAtBirth"/>
                                                        </fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                    <fo:table-row>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>4.1.1.8.3. Forename of father</fo:block>
                                                      </fo:table-cell>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>
                                                          <xsl:value-of select="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/forenameFather"/>
                                                        </fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                    <fo:table-row>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>4.1.1.8.4. Mother's family name at birth</fo:block>
                                                      </fo:table-cell>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>
                                                          <xsl:value-of select="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/motherFamilyNameAtBirth"/>
                                                        </fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                    <fo:table-row>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>4.1.1.8.5. Forename of mother</fo:block>
                                                      </fo:table-cell>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>
                                                          <xsl:value-of select="//FillInIfStatusPersonFamilyMember/InsuredPerson/PersonIdentification/IfPINNotProvidedForEveryInstitutionPleaseProvide/forenameMother"/>
                                                        </fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                  </fo:table-body>
                                                </fo:table>
                                              </fo:block>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                      </fo:table-body>
                                    </fo:table>
                                  </fo:block>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell number-columns-spanned="2">
                                <fo:block>
                                  <fo:block>
                                    <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                      <fo:table-column column-width="45%"/>
                                      <fo:table-column column-width="53%"/>
                                      <fo:table-header background-color="LightGrey">
                                        <fo:table-row border="solid 0.2mm Grey">
                                          <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>4.1.2. Additional information on the person</fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                      </fo:table-header>
                                      <fo:table-body>
                                        <fo:table-row>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>4.1.2.1. Nationality</fo:block>
                                          </fo:table-cell>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>
                                              <xsl:value-of select="//FillInIfStatusPersonFamilyMember/InsuredPerson/AdditionalInformationPerson/nationality"/>  
                                              <fo:block>
                                                <xsl:for-each select="//FillInIfStatusPersonFamilyMember/InsuredPerson/AdditionalInformationPerson/nationality/value">
                                                  <xsl:choose>
                                                    <xsl:when test=".='PS'">
                                                      <fo:block>Palestine, State of</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='PT'">
                                                      <fo:block>Portugal</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='PW'">
                                                      <fo:block>Palau</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='PY'">
                                                      <fo:block>Paraguay</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='QA'">
                                                      <fo:block>Qatar</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='PCHH'">
                                                      <fo:block>Pacific Islands, Trust Territory of the</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='AD'">
                                                      <fo:block>Andorra</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='AE'">
                                                      <fo:block>United Arab Emirates (the)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='AF'">
                                                      <fo:block>Afghanistan</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='AG'">
                                                      <fo:block>Antigua and Barbuda</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='AL'">
                                                      <fo:block>Albania</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='AM'">
                                                      <fo:block>Armenia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='AO'">
                                                      <fo:block>Angola</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='AR'">
                                                      <fo:block>Argentina</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='AT'">
                                                      <fo:block>Austria</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='AU'">
                                                      <fo:block>Australia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='AZ'">
                                                      <fo:block>Azerbaijan</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='RO'">
                                                      <fo:block>Romania</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BA'">
                                                      <fo:block>Bosnia and Herzegovina</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BB'">
                                                      <fo:block>Barbados</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='RS'">
                                                      <fo:block>Serbia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BD'">
                                                      <fo:block>Bangladesh</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BE'">
                                                      <fo:block>Belgium</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='RU'">
                                                      <fo:block>Russian Federation (the)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BF'">
                                                      <fo:block>Burkina Faso</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='WKUM'">
                                                      <fo:block>Wake Island</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BG'">
                                                      <fo:block>Bulgaria</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='RW'">
                                                      <fo:block>Rwanda</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BH'">
                                                      <fo:block>Bahrain</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BI'">
                                                      <fo:block>Burundi</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BJ'">
                                                      <fo:block>Benin</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BN'">
                                                      <fo:block>Brunei Darussalam</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BO'">
                                                      <fo:block>Bolivia (Plurinational State of)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SA'">
                                                      <fo:block>Saudi Arabia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SB'">
                                                      <fo:block>Solomon Islands</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BR'">
                                                      <fo:block>Brazil</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SC'">
                                                      <fo:block>Seychelles</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BS'">
                                                      <fo:block>Bahamas (the)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SD'">
                                                      <fo:block>Sudan (the)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SE'">
                                                      <fo:block>Sweden</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BT'">
                                                      <fo:block>Bhutan</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SG'">
                                                      <fo:block>Singapore</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BW'">
                                                      <fo:block>Botswana</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SI'">
                                                      <fo:block>Slovenia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BY'">
                                                      <fo:block>Belarus</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SK'">
                                                      <fo:block>Slovakia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BZ'">
                                                      <fo:block>Belize</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SL'">
                                                      <fo:block>Sierra Leone</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SM'">
                                                      <fo:block>San Marino</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SN'">
                                                      <fo:block>Senegal</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SO'">
                                                      <fo:block>Somalia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CA'">
                                                      <fo:block>Canada</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SR'">
                                                      <fo:block>Suriname</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SS'">
                                                      <fo:block>South Sudan</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CD'">
                                                      <fo:block>Congo, the Democratic Republic of the</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='ST'">
                                                      <fo:block>Sao Tome and Principe</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CF'">
                                                      <fo:block>Central African Republic (the)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SV'">
                                                      <fo:block>El Salvador</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CG'">
                                                      <fo:block>Congo</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CH'">
                                                      <fo:block>Switzerland</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CI'">
                                                      <fo:block>Côte d'Ivoire</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SY'">
                                                      <fo:block>Syrian Arab Republic</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SZ'">
                                                      <fo:block>Swaziland</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CL'">
                                                      <fo:block>Chile</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CM'">
                                                      <fo:block>Cameroon</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CN'">
                                                      <fo:block>China</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CO'">
                                                      <fo:block>Colombia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CR'">
                                                      <fo:block>Costa Rica</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='TD'">
                                                      <fo:block>Chad</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CU'">
                                                      <fo:block>Cuba</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CV'">
                                                      <fo:block>Cabo Verde</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='TG'">
                                                      <fo:block>Togo</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='TH'">
                                                      <fo:block>Thailand</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CY'">
                                                      <fo:block>Cyprus</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='TJ'">
                                                      <fo:block>Tajikistan</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CZ'">
                                                      <fo:block>Czechia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='TL'">
                                                      <fo:block>Timor-Leste</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='TM'">
                                                      <fo:block>Turkmenistan</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='TN'">
                                                      <fo:block>Tunisia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='TO'">
                                                      <fo:block>Tonga</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='TR'">
                                                      <fo:block>Turkey</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='GEHH'">
                                                      <fo:block>Gilbert and Ellice Islands</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='TT'">
                                                      <fo:block>Trinidad and Tobago</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='DE'">
                                                      <fo:block>Germany</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='TV'">
                                                      <fo:block>Tuvalu</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='DJ'">
                                                      <fo:block>Djibouti</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='TZ'">
                                                      <fo:block>Tanzania, United Republic of</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='DK'">
                                                      <fo:block>Denmark</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='DM'">
                                                      <fo:block>Dominica</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='DO'">
                                                      <fo:block>Dominican Republic (the)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='UA'">
                                                      <fo:block>Ukraine</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='UG'">
                                                      <fo:block>Uganda</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='UK'">
                                                      <fo:block>United Kingdom</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='DZ'">
                                                      <fo:block>Algeria</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='EC'">
                                                      <fo:block>Ecuador</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='US'">
                                                      <fo:block>United States of America (the)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='EE'">
                                                      <fo:block>Estonia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BQAQ'">
                                                      <fo:block>British Antarctic Territory</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='EG'">
                                                      <fo:block>Egypt</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='UY'">
                                                      <fo:block>Uruguay</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='UZ'">
                                                      <fo:block>Uzbekistan</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='YUCS'">
                                                      <fo:block>Yugoslavia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='EL'">
                                                      <fo:block>Greece</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BYAA'">
                                                      <fo:block>Byelorussian SSR</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='VA'">
                                                      <fo:block>Holy See (the)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='ER'">
                                                      <fo:block>Eritrea</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='VC'">
                                                      <fo:block>Saint Vincent and the Grenadines</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='ES'">
                                                      <fo:block>Spain</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='ET'">
                                                      <fo:block>Ethiopia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='VE'">
                                                      <fo:block>Venezuela (Bolivarian Republic of)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='AIDJ'">
                                                      <fo:block>French Afar and Issas</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='VN'">
                                                      <fo:block>Viet Nam</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='VU'">
                                                      <fo:block>Vanuatu</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='FI'">
                                                      <fo:block>Finland</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='FJ'">
                                                      <fo:block>Fiji</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SUHH'">
                                                      <fo:block>USSR</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='FM'">
                                                      <fo:block>Micronesia (Federated States of)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='FR'">
                                                      <fo:block>France</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='GA'">
                                                      <fo:block>Gabon</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='WS'">
                                                      <fo:block>Samoa</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='GD'">
                                                      <fo:block>Grenada</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='GE'">
                                                      <fo:block>Georgia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='GH'">
                                                      <fo:block>Ghana</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='GM'">
                                                      <fo:block>Gambia (the)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='GN'">
                                                      <fo:block>Guinea</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='GQ'">
                                                      <fo:block>Equatorial Guinea</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='GT'">
                                                      <fo:block>Guatemala</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='GW'">
                                                      <fo:block>Guinea-Bissau</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='GY'">
                                                      <fo:block>Guyana</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='XR'">
                                                      <fo:block>Refugee</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='XS'">
                                                      <fo:block>Stateless Person</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='XU'">
                                                      <fo:block>Unknown</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='HN'">
                                                      <fo:block>Honduras</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='HR'">
                                                      <fo:block>Croatia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='HT'">
                                                      <fo:block>Haiti</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='YE'">
                                                      <fo:block>Yemen</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='HU'">
                                                      <fo:block>Hungary</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MIUM'">
                                                      <fo:block>Midway Islands</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='NQAQ'">
                                                      <fo:block>Dronning Maud Land</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='ID'">
                                                      <fo:block>Indonesia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='IE'">
                                                      <fo:block>Ireland</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='DDDE'">
                                                      <fo:block>German Democratic Republic</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='IL'">
                                                      <fo:block>Israel</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='IN'">
                                                      <fo:block>India</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='ZA'">
                                                      <fo:block>South Africa</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='IQ'">
                                                      <fo:block>Iraq</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='IR'">
                                                      <fo:block>Iran (Islamic Republic of)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='IS'">
                                                      <fo:block>Iceland</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='FQHH'">
                                                      <fo:block>French Southern and Antarctic Territories</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='IT'">
                                                      <fo:block>Italy</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='BUMM'">
                                                      <fo:block>Burma</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='ZM'">
                                                      <fo:block>Zambia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='ZW'">
                                                      <fo:block>Zimbabwe</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='FXFR'">
                                                      <fo:block>France, Metropolitan</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='JTUM'">
                                                      <fo:block>Johnston Island</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='JM'">
                                                      <fo:block>Jamaica</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='JO'">
                                                      <fo:block>Jordan</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='JP'">
                                                      <fo:block>Japan</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='KE'">
                                                      <fo:block>Kenya</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='SKIN'">
                                                      <fo:block>Sikkim</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='KG'">
                                                      <fo:block>Kyrgyzstan</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='KH'">
                                                      <fo:block>Cambodia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='KI'">
                                                      <fo:block>Kiribati</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='PZPA'">
                                                      <fo:block>Panama Canal Zone</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='KM'">
                                                      <fo:block>Comoros (the)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='NTHH'">
                                                      <fo:block>Neutral Zone</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='KN'">
                                                      <fo:block>Saint Kitts and Nevis</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='KP'">
                                                      <fo:block>Korea (the Democratic People's Republic of)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='KR'">
                                                      <fo:block>Korea (the Republic of)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='KW'">
                                                      <fo:block>Kuwait</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='KZ'">
                                                      <fo:block>Kazakhstan</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CSHH'">
                                                      <fo:block>Czechoslovakia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CSXX'">
                                                      <fo:block>Serbia and Montenegro</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='LA'">
                                                      <fo:block>Lao People's Democratic Republic (the)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='LB'">
                                                      <fo:block>Lebanon</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='LC'">
                                                      <fo:block>Saint Lucia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='PUUM'">
                                                      <fo:block>Us Miscellaneous Pacific Islands</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='LI'">
                                                      <fo:block>Liechtenstein</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='YDYE'">
                                                      <fo:block>Yemen, Democratic</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='LK'">
                                                      <fo:block>Sri Lanka</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='LR'">
                                                      <fo:block>Liberia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='LS'">
                                                      <fo:block>Lesotho</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='LT'">
                                                      <fo:block>Lithuania</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='LU'">
                                                      <fo:block>Luxembourg</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='LV'">
                                                      <fo:block>Latvia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='LY'">
                                                      <fo:block>Libya</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='CTKI'">
                                                      <fo:block>Canton and Enderbury Islands</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MA'">
                                                      <fo:block>Morocco</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MC'">
                                                      <fo:block>Monaco</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MD'">
                                                      <fo:block>Moldova (the Republic of)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='ME'">
                                                      <fo:block>Montenegro</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MG'">
                                                      <fo:block>Madagascar</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MH'">
                                                      <fo:block>Marshall Islands (the)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MK'">
                                                      <fo:block>Macedonia (the former Yugoslav Republic of)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='ML'">
                                                      <fo:block>Mali</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MM'">
                                                      <fo:block>Myanmar</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MN'">
                                                      <fo:block>Mongolia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MR'">
                                                      <fo:block>Mauritania</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MT'">
                                                      <fo:block>Malta</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MU'">
                                                      <fo:block>Mauritius</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MV'">
                                                      <fo:block>Maldives</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MW'">
                                                      <fo:block>Malawi</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MX'">
                                                      <fo:block>Mexico</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MY'">
                                                      <fo:block>Malaysia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='MZ'">
                                                      <fo:block>Mozambique</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='NA'">
                                                      <fo:block>Namibia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='ZRCD'">
                                                      <fo:block>Zaire</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='NE'">
                                                      <fo:block>Niger (the)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='NG'">
                                                      <fo:block>Nigeria</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='NI'">
                                                      <fo:block>Nicaragua</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='DYBJ'">
                                                      <fo:block>Dahomey</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='NL'">
                                                      <fo:block>Netherlands</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='NO'">
                                                      <fo:block>Norway</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='NP'">
                                                      <fo:block>Nepal</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='NR'">
                                                      <fo:block>Nauru</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='NZ'">
                                                      <fo:block>New Zealand</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='VDVN'">
                                                      <fo:block>Viet-Nam, Democratic Republic of</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='TPTL'">
                                                      <fo:block>East Timor</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='RHZW'">
                                                      <fo:block>Southern Rhodesia</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='NHVU'">
                                                      <fo:block>New Hebrides</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='OM'">
                                                      <fo:block>Oman</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='HVBF'">
                                                      <fo:block>Upper Volta</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='PA'">
                                                      <fo:block>Panama</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='ANHH'">
                                                      <fo:block>Netherlands Antilles</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='PE'">
                                                      <fo:block>Peru</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='PG'">
                                                      <fo:block>Papua New Guinea</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='PH'">
                                                      <fo:block>Philippines (the)</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='PK'">
                                                      <fo:block>Pakistan</fo:block>
                                                    </xsl:when>
                                                    <xsl:when test=".='PL'">
                                                      <fo:block>Poland</fo:block>
                                                    </xsl:when>
                                                    <xsl:otherwise>
                                                      <fo:block>-/-</fo:block>
                                                    </xsl:otherwise>
                                                  </xsl:choose>
                                                </xsl:for-each>
                                              </fo:block>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                      </fo:table-body>
                                    </fo:table>
                                  </fo:block>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                          </fo:table-body>
                        </fo:table>
                      </fo:block>
                    </fo:block>
                  </fo:table-cell>
                </fo:table-row>
                <fo:table-row>
                  <fo:table-cell number-columns-spanned="2">
                    <fo:block>
                      <fo:block>
                        <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                          <fo:table-column column-width="45%"/>
                          <fo:table-column column-width="53%"/>
                          <fo:table-header background-color="LightGrey">
                            <fo:table-row border="solid 0.2mm Grey">
                              <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                <fo:block>4.2. Address of the main insured person</fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                          </fo:table-header>
                          <fo:table-body>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>4.2.1. Street</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/street"/>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>4.2.2. Building Name</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/buildingName"/>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>4.2.3. Town</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/town"/>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>4.2.4. Postal Code</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/postalCode"/>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>4.2.5. Region</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/region"/>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>4.2.6. Country</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country"/>  
                                  <fo:block>
                                    <xsl:choose>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='PR'">
                                        <fo:block>Puerto Rico</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='PS'">
                                        <fo:block>Palestine, State of</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='PT'">
                                        <fo:block>Portugal</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='PW'">
                                        <fo:block>Palau</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='PY'">
                                        <fo:block>Paraguay</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='QA'">
                                        <fo:block>Qatar</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AD'">
                                        <fo:block>Andorra</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AE'">
                                        <fo:block>United Arab Emirates (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AF'">
                                        <fo:block>Afghanistan</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AG'">
                                        <fo:block>Antigua and Barbuda</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AI'">
                                        <fo:block>Anguilla</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AL'">
                                        <fo:block>Albania</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AM'">
                                        <fo:block>Armenia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AO'">
                                        <fo:block>Angola</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AQ'">
                                        <fo:block>Antarctica</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AR'">
                                        <fo:block>Argentina</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AS'">
                                        <fo:block>American Samoa</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AT'">
                                        <fo:block>Austria</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='RE'">
                                        <fo:block>Réunion</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AU'">
                                        <fo:block>Australia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AW'">
                                        <fo:block>Aruba</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AX'">
                                        <fo:block>Aland Islands</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='AZ'">
                                        <fo:block>Azerbaijan</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='RO'">
                                        <fo:block>Romania</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BA'">
                                        <fo:block>Bosnia and Herzegovina</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BB'">
                                        <fo:block>Barbados</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='RS'">
                                        <fo:block>Serbia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BD'">
                                        <fo:block>Bangladesh</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BE'">
                                        <fo:block>Belgium</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='RU'">
                                        <fo:block>Russian Federation (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BF'">
                                        <fo:block>Burkina Faso</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BG'">
                                        <fo:block>Bulgaria</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='RW'">
                                        <fo:block>Rwanda</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BH'">
                                        <fo:block>Bahrain</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BI'">
                                        <fo:block>Burundi</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BJ'">
                                        <fo:block>Benin</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BL'">
                                        <fo:block>Saint Barthélemy</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BM'">
                                        <fo:block>Bermuda</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BN'">
                                        <fo:block>Brunei Darussalam</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BO'">
                                        <fo:block>Bolivia (Plurinational State of)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SA'">
                                        <fo:block>Saudi Arabia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BQ'">
                                        <fo:block>Bonaire, Sint Eustatius and Saba</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SB'">
                                        <fo:block>Solomon Islands</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BR'">
                                        <fo:block>Brazil</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SC'">
                                        <fo:block>Seychelles</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BS'">
                                        <fo:block>Bahamas (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SD'">
                                        <fo:block>Sudan (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SE'">
                                        <fo:block>Sweden</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BT'">
                                        <fo:block>Bhutan</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BV'">
                                        <fo:block>Bouvet Island</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SG'">
                                        <fo:block>Singapore</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BW'">
                                        <fo:block>Botswana</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SH'">
                                        <fo:block>Saint Helena, Ascension and Tristan da Cunha</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SI'">
                                        <fo:block>Slovenia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BY'">
                                        <fo:block>Belarus</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SJ'">
                                        <fo:block>Svalbard and Jan Mayen</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SK'">
                                        <fo:block>Slovakia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='BZ'">
                                        <fo:block>Belize</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SL'">
                                        <fo:block>Sierra Leone</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SM'">
                                        <fo:block>San Marino</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SN'">
                                        <fo:block>Senegal</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SO'">
                                        <fo:block>Somalia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CA'">
                                        <fo:block>Canada</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SR'">
                                        <fo:block>Suriname</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CC'">
                                        <fo:block>Cocos (Keeling) Islands (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SS'">
                                        <fo:block>South Sudan</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CD'">
                                        <fo:block>Congo, the Democratic Republic of the</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='ST'">
                                        <fo:block>Sao Tome and Principe</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CF'">
                                        <fo:block>Central African Republic (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SV'">
                                        <fo:block>El Salvador</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CG'">
                                        <fo:block>Congo</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CH'">
                                        <fo:block>Switzerland</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SX'">
                                        <fo:block>Sint Maarten (Dutch part)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CI'">
                                        <fo:block>Cote d'Ivoire</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SY'">
                                        <fo:block>Syrian Arab Republic</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='SZ'">
                                        <fo:block>Swaziland</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CK'">
                                        <fo:block>Cook Islands (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CL'">
                                        <fo:block>Chile</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CM'">
                                        <fo:block>Cameroon</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CN'">
                                        <fo:block>China</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CO'">
                                        <fo:block>Colombia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CR'">
                                        <fo:block>Costa Rica</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TC'">
                                        <fo:block>Turks and Caicos Islands (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TD'">
                                        <fo:block>Chad</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CU'">
                                        <fo:block>Cuba</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TF'">
                                        <fo:block>French Southern Territories (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CV'">
                                        <fo:block>Cabo Verde</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TG'">
                                        <fo:block>Togo</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CW'">
                                        <fo:block>Curaçao</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TH'">
                                        <fo:block>Thailand</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CX'">
                                        <fo:block>Christmas Island</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CY'">
                                        <fo:block>Cyprus</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TJ'">
                                        <fo:block>Tajikistan</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='CZ'">
                                        <fo:block>Czechia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TK'">
                                        <fo:block>Tokelau</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TL'">
                                        <fo:block>Timor-Leste</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TM'">
                                        <fo:block>Turkmenistan</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TN'">
                                        <fo:block>Tunisia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TO'">
                                        <fo:block>Tonga</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TR'">
                                        <fo:block>Turkey</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TT'">
                                        <fo:block>Trinidad and Tobago</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='DE'">
                                        <fo:block>Germany</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TV'">
                                        <fo:block>Tuvalu</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TW'">
                                        <fo:block>Taiwan (Province of China)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='DJ'">
                                        <fo:block>Djibouti</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='TZ'">
                                        <fo:block>Tanzania, United Republic of</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='DK'">
                                        <fo:block>Denmark</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='DM'">
                                        <fo:block>Dominica</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='DO'">
                                        <fo:block>Dominican Republic (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='UA'">
                                        <fo:block>Ukraine</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='UG'">
                                        <fo:block>Uganda</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='UK'">
                                        <fo:block>United Kingdom</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='DZ'">
                                        <fo:block>Algeria</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='UM'">
                                        <fo:block>United States Minor Outlying Islands (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='EC'">
                                        <fo:block>Ecuador</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='US'">
                                        <fo:block>United States of America (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='EE'">
                                        <fo:block>Estonia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='EG'">
                                        <fo:block>Egypt</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='EH'">
                                        <fo:block>Western Sahara</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='UY'">
                                        <fo:block>Uruguay</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='UZ'">
                                        <fo:block>Uzbekistan</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='EL'">
                                        <fo:block>Greece</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='VA'">
                                        <fo:block>Holy See (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='ER'">
                                        <fo:block>Eritrea</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='VC'">
                                        <fo:block>Saint Vincent and the Grenadines</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='ES'">
                                        <fo:block>Spain</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='ET'">
                                        <fo:block>Ethiopia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='VE'">
                                        <fo:block>Venezuela (Bolivarian Republic of)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='VG'">
                                        <fo:block>Virgin Islands (British)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='VI'">
                                        <fo:block>Virgin Islands (U.S.)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='VN'">
                                        <fo:block>Viet Nam</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='VU'">
                                        <fo:block>Vanuatu</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='FI'">
                                        <fo:block>Finland</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='FJ'">
                                        <fo:block>Fiji</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='FK'">
                                        <fo:block>Falkland Islands (the) [Malvinas]</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='FM'">
                                        <fo:block>Micronesia (Federated States of)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='FO'">
                                        <fo:block>Faroe Islands (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='FR'">
                                        <fo:block>France</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='WF'">
                                        <fo:block>Wallis and Futuna</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GA'">
                                        <fo:block>Gabon</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='WS'">
                                        <fo:block>Samoa</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GD'">
                                        <fo:block>Grenada</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GE'">
                                        <fo:block>Georgia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GF'">
                                        <fo:block>French Guiana</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GG'">
                                        <fo:block>Guernsey</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GH'">
                                        <fo:block>Ghana</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GI'">
                                        <fo:block>Gibraltar</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GL'">
                                        <fo:block>Greenland</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GM'">
                                        <fo:block>Gambia (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GN'">
                                        <fo:block>Guinea</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GP'">
                                        <fo:block>Guadeloupe</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GQ'">
                                        <fo:block>Equatorial Guinea</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GS'">
                                        <fo:block>South Georgia and the South Sandwich Islands</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GT'">
                                        <fo:block>Guatemala</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GU'">
                                        <fo:block>Guam</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GW'">
                                        <fo:block>Guinea-Bissau</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='GY'">
                                        <fo:block>Guyana</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='HK'">
                                        <fo:block>Hong Kong</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='HM'">
                                        <fo:block>Heard Island and McDonald Islands</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='HN'">
                                        <fo:block>Honduras</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='HR'">
                                        <fo:block>Croatia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='HT'">
                                        <fo:block>Haiti</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='YE'">
                                        <fo:block>Yemen</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='HU'">
                                        <fo:block>Hungary</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='ID'">
                                        <fo:block>Indonesia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='YT'">
                                        <fo:block>Mayotte</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='IE'">
                                        <fo:block>Ireland</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='IL'">
                                        <fo:block>Israel</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='IM'">
                                        <fo:block>Isle of Man</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='IN'">
                                        <fo:block>India</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='IO'">
                                        <fo:block>British Indian Ocean Territory (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='ZA'">
                                        <fo:block>South Africa</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='IQ'">
                                        <fo:block>Iraq</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='IR'">
                                        <fo:block>Iran (Islamic Republic of)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='IS'">
                                        <fo:block>Iceland</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='IT'">
                                        <fo:block>Italy</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='ZM'">
                                        <fo:block>Zambia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='JE'">
                                        <fo:block>Jersey</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='ZW'">
                                        <fo:block>Zimbabwe</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='JM'">
                                        <fo:block>Jamaica</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='JO'">
                                        <fo:block>Jordan</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='JP'">
                                        <fo:block>Japan</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='KE'">
                                        <fo:block>Kenya</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='KG'">
                                        <fo:block>Kyrgyzstan</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='KH'">
                                        <fo:block>Cambodia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='KI'">
                                        <fo:block>Kiribati</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='KM'">
                                        <fo:block>Comoros</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='KN'">
                                        <fo:block>Saint Kitts and Nevis</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='KP'">
                                        <fo:block>Korea (the Democratic People's Republic of)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='KR'">
                                        <fo:block>Korea (the Republic of)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='KW'">
                                        <fo:block>Kuwait</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='KY'">
                                        <fo:block>Cayman Islands (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='KZ'">
                                        <fo:block>Kazakhstan</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='LA'">
                                        <fo:block>Lao People's Democratic Republic (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='LB'">
                                        <fo:block>Lebanon</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='LC'">
                                        <fo:block>Saint Lucia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='LI'">
                                        <fo:block>Liechtenstein</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='LK'">
                                        <fo:block>Sri Lanka</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='LR'">
                                        <fo:block>Liberia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='LS'">
                                        <fo:block>Lesotho</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='LT'">
                                        <fo:block>Lithuania</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='LU'">
                                        <fo:block>Luxembourg</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='LV'">
                                        <fo:block>Latvia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='LY'">
                                        <fo:block>Libya</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MA'">
                                        <fo:block>Morocco</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MC'">
                                        <fo:block>Monaco</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MD'">
                                        <fo:block>Moldova (the Republic of)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='ME'">
                                        <fo:block>Montenegro</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MF'">
                                        <fo:block>Saint Martin (French part)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MG'">
                                        <fo:block>Madagascar</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MH'">
                                        <fo:block>Marshall Islands (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MK'">
                                        <fo:block>Macedonia (the former Yugoslav Republic of)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='ML'">
                                        <fo:block>Mali</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MM'">
                                        <fo:block>Myanmar</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MN'">
                                        <fo:block>Mongolia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MO'">
                                        <fo:block>Macao</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MP'">
                                        <fo:block>Northern Mariana Islands (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MQ'">
                                        <fo:block>Martinique</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MR'">
                                        <fo:block>Mauritania</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MS'">
                                        <fo:block>Montserrat</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MT'">
                                        <fo:block>Malta</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MU'">
                                        <fo:block>Mauritius</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MV'">
                                        <fo:block>Maldives</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MW'">
                                        <fo:block>Malawi</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MX'">
                                        <fo:block>Mexico</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MY'">
                                        <fo:block>Malaysia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='MZ'">
                                        <fo:block>Mozambique</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='NA'">
                                        <fo:block>Namibia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='NC'">
                                        <fo:block>New Caledonia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='NE'">
                                        <fo:block>Niger (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='NF'">
                                        <fo:block>Norfolk Island</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='NG'">
                                        <fo:block>Nigeria</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='NI'">
                                        <fo:block>Nicaragua</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='NL'">
                                        <fo:block>Netherlands (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='NO'">
                                        <fo:block>Norway</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='NP'">
                                        <fo:block>Nepal</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='NR'">
                                        <fo:block>Nauru</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='NU'">
                                        <fo:block>Niue</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='NZ'">
                                        <fo:block>New Zealand</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='OM'">
                                        <fo:block>Oman</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='PA'">
                                        <fo:block>Panama</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='PE'">
                                        <fo:block>Peru</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='PF'">
                                        <fo:block>French Polynesia</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='PG'">
                                        <fo:block>Papua New Guinea</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='PH'">
                                        <fo:block>Philippines (the)</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='PK'">
                                        <fo:block>Pakistan</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='PL'">
                                        <fo:block>Poland</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='PM'">
                                        <fo:block>Saint Pierre and Miquelon</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//FillInIfStatusPersonFamilyMember/AddressMainInsuredPerson/country/value='PN'">
                                        <fo:block>Pitcairn</fo:block>
                                      </xsl:when>
                                      <xsl:otherwise>
                                        <fo:block>-/-</fo:block>
                                      </xsl:otherwise>
                                    </xsl:choose>
                                  </fo:block>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                          </fo:table-body>
                        </fo:table>
                      </fo:block>
                    </fo:block>
                  </fo:table-cell>
                </fo:table-row>
              </fo:table-body>
            </fo:table>
          </fo:block>
          <fo:block>
            <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
              <fo:table-column column-width="45%"/>
              <fo:table-column column-width="53%"/>
              <fo:table-header background-color="LightGrey">
                <fo:table-row border="solid 0.2mm Grey">
                  <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm" font-weight="bold">
                    <fo:block>5. Concerns your document</fo:block>
                  </fo:table-cell>
                </fo:table-row>
              </fo:table-header>
              <fo:table-body>
                <fo:table-row>
                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                    <fo:block>5.1. Type of document</fo:block>
                  </fo:table-cell>
                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                    <fo:block>
                      <xsl:value-of select="//ConcernsDocument/typeDocument"/>  
                      <fo:block>
                        <xsl:choose>
                          <xsl:when test="//ConcernsDocument/typeDocument/value='01'">
                            <fo:block>Portable document S1</fo:block>
                          </xsl:when>
                          <xsl:when test="//ConcernsDocument/typeDocument/value='02'">
                            <fo:block>S050</fo:block>
                          </xsl:when>
                          <xsl:when test="//ConcernsDocument/typeDocument/value='03'">
                            <fo:block>SED S072</fo:block>
                          </xsl:when>
                          <xsl:otherwise>
                            <fo:block>-/-</fo:block>
                          </xsl:otherwise>
                        </xsl:choose>
                      </fo:block>
                    </fo:block>
                  </fo:table-cell>
                </fo:table-row>
                <fo:table-row>
                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                    <fo:block>5.2. Issued on</fo:block>
                  </fo:table-cell>
                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                    <fo:block>
                      <xsl:value-of select="//ConcernsDocument/issuedOn"/>
                    </fo:block>
                  </fo:table-cell>
                </fo:table-row>
              </fo:table-body>
            </fo:table>
          </fo:block>
          <fo:block>
            <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
              <fo:table-column column-width="45%"/>
              <fo:table-column column-width="53%"/>
              <fo:table-header background-color="LightGrey">
                <fo:table-row border="solid 0.2mm Grey">
                  <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm" font-weight="bold">
                    <fo:block>6. Entitlement</fo:block>
                  </fo:table-cell>
                </fo:table-row>
              </fo:table-header>
              <fo:table-body>
                <fo:table-row>
                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                    <fo:block>6.1. Entitlement document</fo:block>
                  </fo:table-cell>
                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                    <fo:block>
                      <xsl:value-of select="//Entitlement/entitlementDocument"/>  
                      <fo:block>
                        <xsl:choose>
                          <xsl:when test="//Entitlement/entitlementDocument/value='01'">
                            <fo:block>Portable document S1</fo:block>
                          </xsl:when>
                          <xsl:when test="//Entitlement/entitlementDocument/value='02'">
                            <fo:block>SED S072</fo:block>
                          </xsl:when>
                          <xsl:otherwise>
                            <fo:block>-/-</fo:block>
                          </xsl:otherwise>
                        </xsl:choose>
                      </fo:block>
                    </fo:block>
                  </fo:table-cell>
                </fo:table-row>
                <fo:table-row>
                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                    <fo:block>6.2. Issued on</fo:block>
                  </fo:table-cell>
                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                    <fo:block>
                      <xsl:value-of select="//Entitlement/issuedOn"/>
                    </fo:block>
                  </fo:table-cell>
                </fo:table-row>
              </fo:table-body>
            </fo:table>
          </fo:block>
          <fo:block>
            <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
              <fo:table-column column-width="45%"/>
              <fo:table-column column-width="53%"/>
              <fo:table-header background-color="LightGrey">
                <fo:table-row border="solid 0.2mm Grey">
                  <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm" font-weight="bold">
                    <fo:block>7. Information on registration</fo:block>
                  </fo:table-cell>
                </fo:table-row>
              </fo:table-header>
              <fo:table-body>
                <fo:table-row>
                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                    <fo:block>7.1. Information on registration</fo:block>
                  </fo:table-cell>
                  <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                    <fo:block>
                      <xsl:value-of select="//InformationRegistration/informationRegistration"/>  
                      <fo:block>
                        <xsl:choose>
                          <xsl:when test="//InformationRegistration/informationRegistration/value='01'">
                            <fo:block>Document has been registered</fo:block>
                          </xsl:when>
                          <xsl:when test="//InformationRegistration/informationRegistration/value='02'">
                            <fo:block>Registration has been refused</fo:block>
                          </xsl:when>
                          <xsl:otherwise>
                            <fo:block>-/-</fo:block>
                          </xsl:otherwise>
                        </xsl:choose>
                      </fo:block>
                    </fo:block>
                  </fo:table-cell>
                </fo:table-row>
                <fo:table-row>
                  <fo:table-cell number-columns-spanned="2">
                    <fo:block>
                      <fo:block>
                        <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                          <fo:table-column column-width="45%"/>
                          <fo:table-column column-width="53%"/>
                          <fo:table-header background-color="LightGrey">
                            <fo:table-row border="solid 0.2mm Grey">
                              <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                <fo:block>7.2. Period of registration</fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                          </fo:table-header>
                          <fo:table-body>
                            <fo:table-row>
                              <fo:table-cell number-columns-spanned="2">
                                <fo:block>
                                  <fo:block>
                                    <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                      <fo:table-column column-width="45%"/>
                                      <fo:table-column column-width="53%"/>
                                      <fo:table-header background-color="LightGrey">
                                        <fo:table-row border="solid 0.2mm Grey">
                                          <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>7.2.1. Registration period</fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                      </fo:table-header>
                                      <fo:table-body>
                                        <fo:table-row>
                                          <fo:table-cell number-columns-spanned="2">
                                            <fo:block>
                                              <fo:block>
                                                <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                                  <fo:table-column column-width="45%"/>
                                                  <fo:table-column column-width="53%"/>
                                                  <fo:table-header background-color="LightGrey">
                                                    <fo:table-row border="solid 0.2mm Grey">
                                                      <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>7.2.1.1. Fixed period</fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                  </fo:table-header>
                                                  <fo:table-body>
                                                    <fo:table-row>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>7.2.1.1.1. Start date</fo:block>
                                                      </fo:table-cell>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>
                                                          <xsl:value-of select="//InformationRegistration/PeriodRegistration/RegistrationPeriod/FixedPeriod/startDate"/>
                                                        </fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                    <fo:table-row>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>7.2.1.1.2. End date</fo:block>
                                                      </fo:table-cell>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>
                                                          <xsl:value-of select="//InformationRegistration/PeriodRegistration/RegistrationPeriod/FixedPeriod/endDate"/>
                                                        </fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                  </fo:table-body>
                                                </fo:table>
                                              </fo:block>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                        <fo:table-row>
                                          <fo:table-cell number-columns-spanned="2">
                                            <fo:block>
                                              <fo:block>
                                                <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                                  <fo:table-column column-width="45%"/>
                                                  <fo:table-column column-width="53%"/>
                                                  <fo:table-header background-color="LightGrey">
                                                    <fo:table-row border="solid 0.2mm Grey">
                                                      <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>7.2.1.2. Open period</fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                  </fo:table-header>
                                                  <fo:table-body>
                                                    <fo:table-row>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>7.2.1.2.1. Type of Open Period</fo:block>
                                                      </fo:table-cell>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>
                                                          <xsl:value-of select="//InformationRegistration/PeriodRegistration/RegistrationPeriod/OpenPeriod/typeOpenPeriod"/>  
                                                          <fo:block>
                                                            <xsl:choose>
                                                              <xsl:when test="//InformationRegistration/PeriodRegistration/RegistrationPeriod/OpenPeriod/typeOpenPeriod/value='01'">
                                                                <fo:block>Open-Ended Period</fo:block>
                                                              </xsl:when>
                                                              <xsl:when test="//InformationRegistration/PeriodRegistration/RegistrationPeriod/OpenPeriod/typeOpenPeriod/value='98'">
                                                                <fo:block>End date of the period is unknown</fo:block>
                                                              </xsl:when>
                                                              <xsl:otherwise>
                                                                <fo:block>-/-</fo:block>
                                                              </xsl:otherwise>
                                                            </xsl:choose>
                                                          </fo:block>
                                                        </fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                    <fo:table-row>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>7.2.1.2.2. Start date</fo:block>
                                                      </fo:table-cell>
                                                      <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                                        <fo:block>
                                                          <xsl:value-of select="//InformationRegistration/PeriodRegistration/RegistrationPeriod/OpenPeriod/startDate"/>
                                                        </fo:block>
                                                      </fo:table-cell>
                                                    </fo:table-row>
                                                  </fo:table-body>
                                                </fo:table>
                                              </fo:block>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                      </fo:table-body>
                                    </fo:table>
                                  </fo:block>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                          </fo:table-body>
                        </fo:table>
                      </fo:block>
                    </fo:block>
                  </fo:table-cell>
                </fo:table-row>
                <fo:table-row>
                  <fo:table-cell number-columns-spanned="2">
                    <fo:block>
                      <fo:block>
                        <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                          <fo:table-column column-width="45%"/>
                          <fo:table-column column-width="53%"/>
                          <fo:table-header background-color="LightGrey">
                            <fo:table-row border="solid 0.2mm Grey">
                              <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                <fo:block>7.3. Reason for refusal of registration</fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                          </fo:table-header>
                          <fo:table-body>
                            <fo:table-row>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>7.3.1. Reason</fo:block>
                              </fo:table-cell>
                              <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                <fo:block>
                                  <xsl:value-of select="//InformationRegistration/ReasonForRefusalRegistration/reason"/>  
                                  <fo:block>
                                    <xsl:choose>
                                      <xsl:when test="//InformationRegistration/ReasonForRefusalRegistration/reason/value='99'">
                                        <fo:block>Other reason</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//InformationRegistration/ReasonForRefusalRegistration/reason/value='01'">
                                        <fo:block>Insured as employed or self-employed person in member state of residence since</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//InformationRegistration/ReasonForRefusalRegistration/reason/value='02'">
                                        <fo:block>Insured as pensioner in member state of residence since</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//InformationRegistration/ReasonForRefusalRegistration/reason/value='03'">
                                        <fo:block>Does not fulfil requirement as family member in member state of residence</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//InformationRegistration/ReasonForRefusalRegistration/reason/value='04'">
                                        <fo:block>Does not reside in this member state</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//InformationRegistration/ReasonForRefusalRegistration/reason/value='05'">
                                        <fo:block>Has moved from this member state on</fo:block>
                                      </xsl:when>
                                      <xsl:when test="//InformationRegistration/ReasonForRefusalRegistration/reason/value='06'">
                                        <fo:block>Died on</fo:block>
                                      </xsl:when>
                                      <xsl:otherwise>
                                        <fo:block>-/-</fo:block>
                                      </xsl:otherwise>
                                    </xsl:choose>
                                  </fo:block>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell number-columns-spanned="2">
                                <fo:block>
                                  <fo:block>
                                    <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                      <fo:table-column column-width="45%"/>
                                      <fo:table-column column-width="53%"/>
                                      <fo:table-header background-color="LightGrey">
                                        <fo:table-row border="solid 0.2mm Grey">
                                          <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>7.3.2. Please fill in the following if "Reason" = "01 - Insured as employed or self-employed person in member state of residence since" or "Reason = "02 - Insured as pensioner in member state of residence since" or "Reason = "05 - Has moved from this member stat</fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                      </fo:table-header>
                                      <fo:table-body>
                                        <fo:table-row>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>7.3.2.1. Date</fo:block>
                                          </fo:table-cell>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>
                                              <xsl:value-of select="//InformationRegistration/ReasonForRefusalRegistration/FillInIfReasonInsuredEmployed/date"/>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                      </fo:table-body>
                                    </fo:table>
                                  </fo:block>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                              <fo:table-cell number-columns-spanned="2">
                                <fo:block>
                                  <fo:block>
                                    <fo:table table-layout="fixed" width="100%" margin="2mm 0mm 2mm 2mm" border="solid 0.2mm Grey">
                                      <fo:table-column column-width="45%"/>
                                      <fo:table-column column-width="53%"/>
                                      <fo:table-header background-color="LightGrey">
                                        <fo:table-row border="solid 0.2mm Grey">
                                          <fo:table-cell number-columns-spanned="2" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>7.3.3. Please fill in the following if "Reason" = "99 - Other reason" :</fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                      </fo:table-header>
                                      <fo:table-body>
                                        <fo:table-row>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>7.3.3.1. Other reason</fo:block>
                                          </fo:table-cell>
                                          <fo:table-cell border-top="solid 0.2mm Grey" border-bottom="solid 0.2mm Grey" padding="1mm 0mm 1mm 0mm">
                                            <fo:block>
                                              <xsl:value-of select="//InformationRegistration/ReasonForRefusalRegistration/PleaseFillInFollowingIfReasonOtherReason/otherReason"/>
                                            </fo:block>
                                          </fo:table-cell>
                                        </fo:table-row>
                                      </fo:table-body>
                                    </fo:table>
                                  </fo:block>
                                </fo:block>
                              </fo:table-cell>
                            </fo:table-row>
                          </fo:table-body>
                        </fo:table>
                      </fo:block>
                    </fo:block>
                  </fo:table-cell>
                </fo:table-row>
              </fo:table-body>
            </fo:table>
          </fo:block>
          <fo:block id="endofflow"/>
        </fo:flow>
      </fo:page-sequence>
    </fo:root>
  </xsl:template>
</xsl:stylesheet>
