FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://rsyslog-8.2106.0.patch"
PACKAGECONFIG_remove = "gnutls libgcrypt"
DEPENDS += "wolfssl"
EXTRA_OECONF += "--with-wolfssl=${STAGING_EXECPREFIXDIR}"
