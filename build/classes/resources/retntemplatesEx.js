export const formDRef = [
    "1-'!NQTsematorles'",
    "1-'!NQTsemahozzaadas'",

];

export const retnCombinationTemplates = {
    
};

const retEx = [
    (data, theade="theade") => theade + ":tablerow:tbodyend|||010002FF;" + data,
    (data)=>"theadevcslist:tablerow:tbodyend|||FFFFFFFF;F---FFFFFFFF;F---010002FF;"+data,
    (sendQ, data, h1="") => retEx[0](data, "")
]

export const retnCombinations = {
    etlecta: retEx[0]("002"),
    vacsoralist: 
        "theadevcslist:tablerow:tbodyend:vcstablerow|||" +
        "01FFFFFF;0'+GQTmegetetett---FFFFFFFF;F---FFFFFFFF;F---030002FF;0'+GQTetetes;0-0=0",
    eatedlist: retEx[0]("0'+GQTmegetetett"),
    etlecta2: 
        "theade:tablerow:tbodyend:withselect:seloption|||" +
        "04FFFFFF;0'+GQTnsp---04FFFFFF;0'+GQTproc---030002FF;0'+GQTnsp-0:0-3-3-0-0",
    kolost: 
        "omla:ini:enela:kala;|||FFFFFFFF;3FF;"+
        "2-1=12,3-1=12:2-1=12,3-1=12:---",
    ujvacsora:
        "sela|||"+
        "00FFFFFF;0'+GQTnsp",
    nemtudni: 
        "retndiv:retndivhead|||"+
        "0001FFFF;0'+GQTnsp",
    oklamaha:
        "retrerown:retrehen:retrefoot:retreopt|||" +
        "03FFFFFF;003---03FFFFFF;0'+GQTnsp---000102FF;200-:_-:_-0:1",
    alanylist: retEx[0]("0'+GQTalany"),
    fajlist: retEx[0]("300"),
    pg_class: retEx[0]("302"),
    pg_type: retEx[0]("303"),
}

export const retnCombinationResults = {

};

// QUERRRRRRRRRRRRRRRRRRY
const exmplJSONs= [{
        limit: 50,
        site: 0
    }
];

export const staticQueryWithJSONs = [
    0,
    exmplJSONs[0],
];




